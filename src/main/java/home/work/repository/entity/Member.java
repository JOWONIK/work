package home.work.repository.entity;

import home.work.controller.dto.AllMemberResponseDto;
import home.work.security.Authority;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Table(name = "member")
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 30)
    private String alias;

    @Column(nullable = false, length = 65)
    private String password;

    @Column(name = "CELL_NUMBER", nullable = false, length = 20)
    private String cellNumber;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(length = 2)
    private String sex;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @OneToMany(mappedBy = "member")
    @BatchSize(size = 10)
    @OrderBy("id desc")
    private List<Orders> ordersList = new ArrayList<>();

    @Transient
    private Orders orders;

    @Builder
    public Member(String name, String alias, String password, String cellNumber, String email, String sex, Authority authority) {
        this.name = name;
        this.alias = alias;
        this.password = password;
        this.cellNumber = cellNumber;
        this.email = email;
        this.sex = sex;
        this.authority = authority;
    }

    public static AllMemberResponseDto toEntity(Member m) {
        AllMemberResponseDto a = new AllMemberResponseDto();
        a.setAlias(m.getAlias());
        a.setEmail(m.getEmail());
        a.setCellNumber(m.getCellNumber());
        a.setSex(m.getSex());

        return a;
    }

}
