package home.work.controller.dto;

import home.work.repository.entity.Orders;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AllMemberResponseDto {

    private String email;
    private String name;
    private String alias;
    private String cellNumber;
    private String sex;
    private Orders lastOrder;

}
