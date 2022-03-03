package home.work.repository;

import home.work.repository.entity.Member;
import home.work.utils.SHA256;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired

    @Test
    @DisplayName("회원가입 DB")
    @Transactional
    void save() {
        //g
        Member member = Member.builder()
                .name("조원익")
                .alias("wonya")
                .password("$2a$10$HKAgJgu/E0xJxBkbaogJV.kC.diaVKpiIsDukjUZDBOfwk7Q.zzH")
                .cellNumber("01050175803")
                .email("wonya.dev@gmail.com")
                .sex("M")
                .build();

        //w
        Member saveMember = memberRepository.save(member);

        //t
        Optional<Member> findMember = memberRepository.findById(saveMember.getId());
        assertThat(findMember.get()).isEqualTo(saveMember);
    }

}