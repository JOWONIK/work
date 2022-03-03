package home.work.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import home.work.controller.dto.AllMemberRequestDto;
import home.work.repository.entity.Member;
import home.work.repository.entity.QMember;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static home.work.repository.entity.QMember.member;

@SpringBootTest
public class QueryDslTest {

    @Autowired
    EntityManager em;

    @Autowired
    MemberRespositoryImpl memberRepository;

    @Test
    @Transactional
    void 동적쿼리() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        AllMemberRequestDto a = new AllMemberRequestDto("", "조원");

        List<Member> list = memberRepository.findAllMember(a, PageRequest.of(0, 2));

        Assertions.assertThat(list.size()).isEqualTo(2);
    }

    private BooleanExpression eqName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        return member.name.eq("조원익");
    }
    private BooleanExpression eqEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            return null;
        }
        return member.email.eq("wonya@gmail.com");
    }
}
