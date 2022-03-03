package home.work.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Schema(description = "로그인")
@Setter
@Getter
public class LoginRequestDto {

    @Schema(description = "비밀번호(10자, 영 대소문자, 특수문자, 숫자)", minLength = 10, required = true)
    @NotBlank(message = "비밀번호를 입력해 주세요.")
    @Size(min = 10, max = 100, message = "비밀번호는 최소 10자 이상입니다.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{10,}")
    private String password;

    @Schema(description = "이메일", maxLength = 100, required = true)
    @NotBlank(message = "이메일을 입력해주세요.")
    @Size(min = 1, max = 100, message = "이메일은 1~100자 사이로 입력해주세요.")
    @Email(message = "이메일 형식을 맞춰주세요.")
    private String email;

}