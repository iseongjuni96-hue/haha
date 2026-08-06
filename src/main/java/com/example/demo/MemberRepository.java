package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByUserId(String userId);
    Optional<Member> findByUserId(String userId);
    
    //  이름 + 생년월일로 아이디 찾기
    Optional<Member> findByNameAndBirthdate(String name, String birthdate);

    //  아이디 + 이름 + 생년월일로 비밀번호 찾기
    Optional<Member> findByUserIdAndNameAndBirthdate(String userId, String name, String birthdate);

    
    // 🔥 DB에서 이름 중복 여부를 조회하는 메서드 추가
    boolean existsByName(String name);
    
}