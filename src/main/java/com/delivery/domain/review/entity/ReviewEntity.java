package com.delivery.domain.review.entity;

import com.delivery.domain.review.dto.ReviewDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity // DB가 해당 객체 인식 가능!
@Table(name = "review")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class ReviewEntity {

    @Id // 대표값을 지정! 마치 주민번호처럼
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1,2,3 처럼 auto_increase
    private Long id;

    @Column
    @NotNull
    private String title;

    @Column
    @NotNull
    private String content;

    @Column
    @NotNull
    private String date;

    @Column
    @NotNull
    private String fix_date;

    @Column
    @NotNull
    private String score;

    public static ReviewEntity toSaveEntity(ReviewDto reviewDto){
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setContent(reviewDto.getContent());
        reviewEntity.setDate(reviewDto.getDate());
        reviewEntity.setTitle(reviewDto.getTitle());
        reviewEntity.setScore(reviewDto.getScore());
        reviewEntity.setFix_date(reviewDto.getFix_date());
        return reviewEntity;
    }

}
