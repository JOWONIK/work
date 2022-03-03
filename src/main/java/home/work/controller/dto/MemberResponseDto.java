package home.work.controller.dto;

import home.work.repository.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponseDto {

    private String email;
    private String name;
    private String alias;
    private String cellNumber;
    private String sex;

    public static MemberResponseDto of(Member member) {
        return new MemberResponseDto(member.getEmail(), member.getName(), member.getAlias(), member.getCellNumber(), member.getSex());
    }

}
