package com.delivery.domain.article.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // DB가 해당 객체 인식 가능!
@Table(name = "article_entity")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class ArticleEntity {

    @Id // 대표값을 지정! 마치 주민번호처럼
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1,2,3 처럼 auto_increase
    private Long id;

    @Column
    private String title;
    @Column
    private String content;



}
