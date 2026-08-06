package com.example.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String writer;

    @Column(length = 1000)
    private String content;

    // 💡 파일명이 저장될 필드 추가
    private String fileName;


    //public Board() {
    //}

    //public Board(String title, String content, String writer) {
    //    this.title = title;
    //    this.content = content;
    //    this.writer = writer;
    //}

    //public Long getId() {
    //    return id;
    //}

    //public String getTitle() {
    //    return title;
    //}

    //public String getContent() {
    //    return content;
    //}
    //public String getWritter() {
    //    return writer;
    //}
}