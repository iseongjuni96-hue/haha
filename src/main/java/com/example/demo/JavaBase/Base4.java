package com.example.demo.JavaBase;
import java.util.Scanner;

public class Base4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String id = "shark";
        String pv = "1234";

        System.out.println("아이디를 입력해 주세요.");
        String inputId = sc.next();
        System.out.println("비번을 입력해주세여.");
        String intputPv = sc.next();

        if(inputId.equals(id)) {
            if(intputPv.equals(pv)) {
                System.out.println("로그인 성공!");
            }else {
                System.out.println("비번이 틀렸습니다.");
            }
        }else {
                System.out.println("아이디가 틀렸습니다");
            }
    }
}
