package home.work.repository;

import home.work.controller.dto.AllMemberRequestDto;
import home.work.repository.entity.Member;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberRepositoryCustom {
    List<Member> findAllMember(AllMemberRequestDto allMemberRequestDto, Pageable pageable);
}
