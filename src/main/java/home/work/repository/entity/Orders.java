package home.work.repository.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Table(name = "ORDERS")
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "ORDER_NO", unique = true, nullable = false, length = 12)
    private String orderNo;

    @Column(name = "ITEM_NAME", nullable = false, length = 150)
    private String itemName;

    @CreatedDate
    @Column(name = "PAY_DT", nullable = false)
    private LocalDateTime payDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Builder
    public Orders(String orderNo, String itemName, LocalDateTime payDt, Member member) {
        this.orderNo = orderNo;
        this.itemName = itemName;
        this.payDt = payDt;
        this.member = member;
    }
}