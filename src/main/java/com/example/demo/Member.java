package com.example.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(length = 30, nullable = false)
    private String name;

    private String birthdate; 

    public Member(String userId, String password, String name, String birthdate) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.birthdate = birthdate;
    }
    
}