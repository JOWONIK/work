package home.work.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrdersResponseDto {

    private String orderNo;
    private String itemName;
    private LocalDateTime payDt;

    public OrdersResponseDto(String orderNo, String itemName, LocalDateTime payDt) {
        this.orderNo = orderNo;
        this.itemName = itemName;
        this.payDt = payDt;
    }
}
