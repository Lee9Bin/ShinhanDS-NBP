package com.delivery.domain.comment.entity;

import com.delivery.domain.article.entity.ArticleEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "comment")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // 해당 댓글 엔티티 여러개가, 하나의 ArticleEntity에 연관
    @JoinColumn(name = "article_id") // articleid 컬럼에 Article 대표값을 저장
    private ArticleEntity articleEntity;

    @Column
    private String nickName;
    @Column
    private  String body;
}
