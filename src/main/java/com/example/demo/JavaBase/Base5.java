package com.example.demo.JavaBase;
import java.util.Scanner;

public class Base5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("메뉴 번호 입력:");

        int manu = sc.nextInt();
        switch (manu) {
            case 1:
                System.out.println("아메리카노");
                break;
        
            case 2:
                System.out.println("카페라떼");
                break;

            case 4:
                System.out.println("초코라떼");
                break;
            case 5:
                System.out.println("커피");
                break;
            default :
                System.out.println("없는 메뉴입니다.");
        }
    }
}
