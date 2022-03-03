package home.work.service;

import home.work.controller.dto.JoinRequestDto;
import home.work.exception.BusinessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;
    
    @Test
    @DisplayName("회원가입 테스트")
    @Transactional
    public void 회원가입_테스트() {
        //g
        JoinRequestDto req = new JoinRequestDto();
        req.setName("조원익");
        req.setAlias("wonya");
        req.setPassword("1q2w3e4r5t1!");
        req.setCellNumber("01050175803");
        req.setEmail("wonya.dev@gmail.com");

        //w
        memberService.join(req);
    }

    @Test
    @DisplayName("회원가입 이메일 중복")
    @Transactional(propagation = Propagation.NEVER)
    public void 회원가입_이메일_중복() {
        //g
        JoinRequestDto req = new JoinRequestDto();
        req.setName("조원익");
        req.setAlias("wonya");
        req.setPassword("1q2w3e4r5t1!");
        req.setCellNumber("01050175803");
        req.setEmail("wonya.dev@gmail.com");

        JoinRequestDto req2 = new JoinRequestDto();
        req2.setName("조원익");
        req2.setAlias("wonya");
        req2.setPassword("1q2w3e4r5t1!");
        req2.setCellNumber("01050175803");
        req2.setEmail("wonya.dev@gmail.com");

        //w
        memberService.join(req);

        //t
        assertThrows(BusinessException.class,
                () -> memberService.join(req2));
    }
}