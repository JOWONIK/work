package home.work.repository;

import home.work.repository.entity.Member;
import home.work.repository.entity.Orders;
import home.work.utils.SHA256;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrdersRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private OrdersRepository ordersRepository;

    @Test
    void 주문_더미데이터_생성() {

        Member findMember = memberRepository.findByEmail("wonya.dev@gmail.com").get();

        for(int i=0; i<30; i++) {
            Orders order = Orders.builder()
                    .orderNo(String.valueOf((i+60)))
                    .itemName("아이템 "+(i+60))
                    .payDt(LocalDateTime.now())
                    .member(findMember)
                    .build();
            ordersRepository.save(order);
        }
    }

}