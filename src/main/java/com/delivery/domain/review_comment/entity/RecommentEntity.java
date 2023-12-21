package com.delivery.domain.review_comment.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // DB가 해당 객체 인식 가능!
@Table(name = "recomment")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class RecommentEntity {

    @Id // 대표값을 지정! 마치 주민번호처럼
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1,2,3 처럼 auto_increase
    private Long id;

    @Column
    @NotNull
    private Long owner_id;

    @Column
    @NotNull
    private Long review_id;

    @Column
    @NotNull
    private String content;

    @Column
    @NotNull
    private String date;

    @Column
    @NotNull
    private String fix_date;


}
