package com.example.demo.JavaBase.exe06;

public class MemberManager {
    private Member[] members = new Member[10];
    private int count = 0;

    public void addMember(Member member) {
        if(count>=members.length) {
            System.out.println("더 이상 회원을 등록할 수 없습니다.");
            return;
        }
        members[count] = member;
        count++;
        System.out.println("회원이 등록되었습니다.");
    }

    public void printMembers() {
        System.out.println("회원 등록");

        for(int i=0; i < count; i++) {
            members[i].printInfo();
        }
    }
}
