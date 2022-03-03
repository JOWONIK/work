package home.work.controller.dto;

import home.work.repository.entity.Member;
import home.work.security.Authority;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.*;

@Schema(description = "회원가입")
@Setter
@Getter
public class JoinRequestDto {

    @Schema(description = "이름(한, 영 대소문자)", maxLength = 20, required = true)
    @NotBlank(message = "이름을 입력해주세요.")
    @Size(min = 1, max = 20, message = "이름은 1~20자 사이로 입력해 주세요.")
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-zA-Z]*$", message = "이름은 한글, 영어 대소문자만 입력하실 수 있습니다.")
    private String name;

    @Schema(description = "별명(영어 소문자)", maxLength = 30, required = true)
    @NotBlank(message = "별명을 입력해주세요.")
    @Size(min = 1, max = 30, message = "별명은 1~30자 사이로 입력해 주세요.")
    @Pattern(regexp = "^[a-z]*$", message = "별명은 영어 소문자만 입력해 주세요.")
    private String alias;

    @Schema(description = "비밀번호(10자, 영 대소문자, 특수문자, 숫자)", minLength = 10, required = true)
    @NotBlank(message = "비밀번호를 입력해 주세요.")
    @Size(min = 10, max = 100, message = "비밀번호는 최소 10자 이상입니다.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{10,}")
    private String password;

    @Schema(description = "폰번호(숫자만)", maxLength = 20, required = true)
    @NotBlank(message = "휴대폰 번호를 입력해주세요.")
    @Size(min = 1, max = 20, message = "휴대폰 번호는 1~20자 사이입니다.")
    @Positive(message = "전화번호는 숫자만 입력해주세요.")
    private String cellNumber;

    @Schema(description = "이메일", maxLength = 100, required = true)
    @NotBlank(message = "이메일을 입력해주세요.")
    @Size(min = 1, max = 100, message = "이메일은 1~100자 사이로 입력해주세요.")
    @Email(message = "이메일 형식을 맞춰주세요.")
    private String email;

    @Schema(description = "성별", example = "M")
    @Pattern(regexp = "(^$|^[M|W]$)", message = "성별은 M or W 만 가능합니다.")
    private String sex;

    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .name(name)
                .alias(alias)
                .cellNumber(cellNumber)
                .sex(sex)
                .authority(Authority.ROLE_USER)
                .build();
    }
}