package com.example.demo.JavaBase;

import java.util.Scanner;

public class ATM {
    // main 메인 메소드(시작점)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = 10000;
        System.out.println("======ATM======");
        System.out.println("1. 잔액 조회");
        System.out.println("출금");
        System.out.println("입금");
        System.out.println("종료");

        int menu = sc.nextInt();

        if (money==1) { //정수 비교시 == 문자열 equals
            System.out.println("현제 잔액:" + money +"원");
        }else if (menu==2) {
            System.out.println("출금 금액:");
            int amount = sc.nextInt();
            

            if (amount<=money){
                money = money - amount; //출금
                System.out.println("출금 완료");
                System.out.println("남은 잔액:"+ money +"원 남았습니다");
            }else  {
                System.out.println("잔액이 부족합니다.");      
        } 
    }    else if(menu==3){
            System.out.println("입금할 금액을 입력해주세요.");
            int die = sc.nextInt();
            
           if (die > 0) {
            money += die;
            System.out.println("입금이 완료되었습니다.");
            System.out.println("현재 남은 금액:" + money + "입니다.");
           }else {
            System.out.println("올바른 금액을 입력해 주세요.");
           }
    } else if(menu==4) {
        System.out.println("프로그램을 종료합니다.");
    }else {
        System.out.println("질못된 입력입니다.");
    }
  }
}