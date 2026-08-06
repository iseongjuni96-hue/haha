package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@RestController
public class HelloControilor {
    @GetMapping("/home")
    public String home() {
        return "스크립부트 서버 실행 성공";
    }
    
    @GetMapping("/hello")
    public String hello() {
        return "안녕하세요";
    }
    
    @GetMapping("/about")
    public String about() {
        return "여기는 소개 페이지 입니다.";
    }

    @GetMapping("/contact")
    public String contact() {
        return "연락처 페이지입니다.";
    }
    
    @GetMapping("/add")
    public String add() {
        int a= 10;
        int b= 20;
        int result = a+b;
        return "결과:" + result;
    }

    @GetMapping("/number")
    public String number() {
        int math = 80;
        int eng = 75;
        int kor = 85;
        double avg = (math + kor + eng) / 3.0 ;
        return "평균:" + avg;
    }

    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable String name){
        return name + "님 안녕하세요!";
    }
    
    @GetMapping("/square/{num}")
    public String square(@PathVariable int num) {
        return num + "의 제곱은" + (num * num) + "입니다";
    }

    @GetMapping("/welcome")
    public String welcome(@RequestParam String name) {
        return name + "님 환영합니다.";
    }
    
    @GetMapping("/student")
    public Student student() {
        return new Student("김자바 ",90);
    }

    @GetMapping("/students")
    public List<Student>students() {
        List<Student>list = new ArrayList<>();

        list.add(new Student("김자바", 90));
        list.add(new Student("여자바", 80));
        list.add(new Student("박자바", 70));
        
        return list;
    }

    @GetMapping("/api/message")
    public String message() {
        return "스프링에서 온 메시지입니다.";
    }

    @GetMapping("/api/student")
    public Student apiStudent() {
        return new Student("김나나", 90);
    }

    @GetMapping("/api/students")
    public List<Student>apiStudents() {
        List<Student>list = new ArrayList<>();
        list.add(new Student("김나나", 90));
        list.add(new Student("김김김", 80));
        list.add(new Student("김바바", 70));

        return list;
    }
    
    @PostMapping("/api/echo")
    public Map<String, String>echo(@RequestBody Map<String, String>data) {
        return data;
    }
}