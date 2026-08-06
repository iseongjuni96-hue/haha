package com.example.demo.JavaBase.exe06;

public class main {
    public static void main(String[] args) {
        MemberManager manager = new MemberManager();

        manager.addMember(new Member("user1","홍길동",20));
        manager.addMember(new Member("user2","김나나",25));
        manager.addMember(new Member("user3","노노",30));

        // manager.count= 100;
        // manager.members = null; 
        // 접근 제어 public,private,protected,default
    }
}
