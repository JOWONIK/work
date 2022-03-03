package home.work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkApplication.class, args);
	}

}

/**
 * - 회원 가입
 * [POST] /members
 * - 회원 로그인(인증)
 * [POST] /members/login
 * - 회원 로그아웃
 * [POST] /members/logout
 * - 단일 회원 상세 정보 조회
 * [GET] /members/{mid}
 * - 단일 회원의 주문 목록 조회
 * [GET] /members/{mid}/orders
 *
 *
 * - 여러 회원 목록 조회 :
 * [GET] /members?blahblah
 * 	- 페이지네이션으로 일정 단위로 조회합니다.
 * 	- 이름, 이메일을 이용하여 검색 기능이 필요합니다.
 * 	- 각 회원의 마지막 주문 정보
 */
