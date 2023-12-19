package com.delivery.domain.article.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "article")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String title;

    @NotNull
    @Column
    private String content;

    public void patch(ArticleEntity articleEntity){
        if(articleEntity.title !=null){
            this.title = articleEntity.title;
        }
        if(articleEntity.content !=null){
            this.content = articleEntity.content;
        }
    }
}
