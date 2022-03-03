package home.work.controller;

import home.work.controller.dto.*;
import home.work.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Tag(name = "MEMBER", description = "회원 API")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "members")
public class MemberController {

    private final MemberService memberService;

    @Tag(name = "MEMBER")
    @Operation(summary = "회원가입", description = "자체 회원가입")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "가입완료"),
            @ApiResponse(responseCode = "5000", description = "이메일이 중복되었습니다.")
    })
    @PostMapping
    public void join(@Valid @RequestBody JoinRequestDto joinRequestDto) {
        memberService.join(joinRequestDto);
    }

    @Tag(name = "MEMBER")
    @Operation(summary = "로그인", description = "JWT 토큰발급")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "로그인완료"),
            @ApiResponse(responseCode = "401", description = "아이디/비번 정보 불일치")
    })
    @PostMapping("login")
    public TokenDto login(@RequestBody MemberRequestDto memberRequestDto) {
        return memberService.login(memberRequestDto);
    }

    @Tag(name = "MEMBER")
    @Operation(summary = "토근재발급", description = "토큰 재발급")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "토큰재발급"),
            @ApiResponse(responseCode = "401", description = "토큰/리프래쉬토큰 정보 불일치"),
            @ApiResponse(responseCode = "6000", description = "TOKEN이 유효하지 않습니다."),
            @ApiResponse(responseCode = "6001", description = "로그인 시간이 만료되었습니다.")
    })
    @PostMapping("reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(memberService.reissue(tokenRequestDto));
    }

    @Tag(name = "MEMBER")
    @Operation(summary = "내 정보", description = "회원 상세정보")
    @GetMapping()
    public MemberResponseDto getMyMemberInfo() {
        return memberService.getMyInfo();
    }
    
    @Tag(name = "MEMBER")
    @Operation(summary = "회원 주문정보", description = "회원 주문정보")
    @GetMapping("orders")
    public List<OrdersResponseDto> getMyOrders() {
        return memberService.getMyOrders();
    }

    @Tag(name = "MEMBER")
    @Operation(summary = "여러 회원 목록 조회", description = "페이지네이션, 이름/이메일 검색")
    @GetMapping("all")
    public List<AllMemberResponseDto> getAllMember(@RequestBody AllMemberRequestDto allMemberRequestDto, final Pageable pageable) {
        return memberService.getAllMember(allMemberRequestDto, pageable);
    }

}
