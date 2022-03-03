package home.work.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import home.work.controller.dto.AllMemberRequestDto;
import home.work.repository.entity.Member;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static home.work.repository.entity.QMember.member;

@RequiredArgsConstructor
@Repository
public class MemberRespositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Member> findAllMember(AllMemberRequestDto allMemberRequestDto, Pageable pageable) {
        return queryFactory.selectFrom(member)
                .where(likeName(allMemberRequestDto.getName()),
                        eqEmail(allMemberRequestDto.getEmail()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    private BooleanExpression likeName(String name) {
        if (StringUtils.isEmpty(name)) return null;
        else return member.name.like("%"+name+"%");
    }
    private BooleanExpression eqEmail(String email) {
        if (StringUtils.isEmpty(email)) return null;
        else return member.email.eq(email);
    }
}
