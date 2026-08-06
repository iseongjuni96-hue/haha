package com.example.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthApiController {

    private final MemberRepository memberRepository;

    // ---------------- 회원가입 API ----------------
    @PostMapping("/api/auth/signup")
    public ResponseEntity<?> signup(@RequestBody MemberDto dto) {
        // 아이디 필수값 검증
        if (dto.getUserid() == null || dto.getUserid().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("아이디를 입력해 주세요.");
        }

        // 아이디 중복 체크
        if (memberRepository.existsByUserId(dto.getUserid())) {
            return ResponseEntity.badRequest().body("중복된 아이디입니다.");
        }

        // 💡 1. 이름 필수 입력 및 30자 제한 검증
        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("이름을 입력해 주세요.");
        }
        if (dto.getName().trim().length() > 30) {
            return ResponseEntity.badRequest().body("이름은 최대 30자까지만 가능합니다.");
        }

        // 💡 2. 이름 중복 체크 (MemberRepository에 existsByName 선언 필요)
        if (memberRepository.existsByName(dto.getName().trim())) {
            return ResponseEntity.badRequest().body("이미 사용 중인 이름입니다. 다른 이름을 사용해 주세요.");
        }

        // 生年月日(birthdate) 포함하여 저장
        Member member = new Member(dto.getUserid(), dto.getPassword(), dto.getName().trim(), dto.getBirthdate());
        memberRepository.save(member);

        return ResponseEntity.ok("가입 완료");
    }

    // ---------------- 로그인 API ----------------
    @PostMapping("/api/auth/login")
    public ResponseEntity<?> login(@RequestBody LoginDto dto) {
        Member member = memberRepository.findByUserId(dto.getUserid()).orElse(null);

        if (member == null) {
            return ResponseEntity.badRequest().body("가입되지 않은 아이디입니다.");
        }

        if (!member.getPassword().equals(dto.getPassword())) {
            return ResponseEntity.badRequest().body("비밀번호가 일치하지 않습니다.");
        }

        Map<String, String> response = new HashMap<>();
        response.put("message", "로그인 성공");
        response.put("userid", member.getUserId());
        response.put("name", member.getName());

        return ResponseEntity.ok(response);
    }

    // ---------------- 아이디 찾기 API ----------------
    @PostMapping("/api/auth/find-id")
    public ResponseEntity<?> findId(@RequestBody FindIdDto dto) {
        if (dto.getName() == null || dto.getBirthdate() == null) {
            return ResponseEntity.badRequest().body("이름과 생년월일을 모두 입력해 주세요.");
        }

        Member member = memberRepository.findByNameAndBirthdate(dto.getName(), dto.getBirthdate())
                .orElse(null);

        if (member == null) {
            return ResponseEntity.badRequest().body("일치하는 회원 정보가 없습니다.");
        }

        return ResponseEntity.ok("찾으시는 아이디는 [" + member.getUserId() + "] 입니다.");
    }

    // ---------------- 비밀번호 찾기 API ----------------
    @PostMapping("/api/auth/find-pw")
    public ResponseEntity<?> findPw(@RequestBody FindPwDto dto) {
        if (dto.getUserid() == null || dto.getName() == null || dto.getBirthdate() == null) {
            return ResponseEntity.badRequest().body("아이디, 이름, 생년월일을 모두 입력해 주세요.");
        }

        Member member = memberRepository.findByUserIdAndNameAndBirthdate(dto.getUserid(), dto.getName(), dto.getBirthdate())
                .orElse(null);

        if (member == null) {
            return ResponseEntity.badRequest().body("일치하는 회원 정보가 없습니다.");
        }

        return ResponseEntity.ok("비밀번호는 [" + member.getPassword() + "] 입니다.");
    }

    // ---------- [DTO 클래스들] ----------
    @Getter @Setter @NoArgsConstructor
    public static class MemberDto {
        private String userid;
        private String password;
        private String name;
        private String birthdate; 
    }

    @Getter @Setter @NoArgsConstructor
    public static class LoginDto {
        private String userid;
        private String password;
    }

    @Getter @Setter @NoArgsConstructor
    public static class FindIdDto {
        private String name;
        private String birthdate;
    }

    @Getter @Setter @NoArgsConstructor
    public static class FindPwDto {
        private String userid;
        private String name;
        private String birthdate;
    }
}