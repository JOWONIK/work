package home.work.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // 회원
    DUPLICATE_EMAIL(5000, "이메일이 중복되었습니다."),

    // 인증
    INVALID_TOKEN(6000, "TOKEN이 유효하지 않습니다."),
    LOGOUT(6001, "로그인 시간이 만료되었습니다.");


    private final int errorCode;
    private final String message;

}
