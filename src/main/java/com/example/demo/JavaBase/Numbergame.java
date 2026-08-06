package com.example.demo.JavaBase;
import java.util.Scanner;
public class Numbergame {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer =7;
        int input = 0;

        while (input!=answer) {
            System.out.println("숫자를 맞춰보세요.");
            input = sc.nextInt();
            if(input == answer)  {
                System.out.println("정답입니다!");
            }else {
                System.out.println("틀렸습니다.");
            }
        }
    }
    
}
