package com.example.demo.JavaBase;

import java.util.Scanner;

public class Base2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("니이 입력:");
        int age =sc.nextInt();

        if(age >= 19) {
            System.out.println("상인입니다.");
        }else {
            System.out.println("미성년자 입니다.");
        }
    }
}
