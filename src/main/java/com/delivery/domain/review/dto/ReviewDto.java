package com.delivery.domain.review.dto;

import com.delivery.domain.review.entity.ReviewEntity;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class ReviewDto {
    private Long id;
    private String title;
    private String content;
    private String date;
    private String fix_date;
    private String score;

    public ReviewEntity toEntity() {
        return new ReviewEntity(id, title, content, date, fix_date, score);
    }

    public ReviewDto(Long id, String title, String content, String date, String fix_date, String score) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.fix_date = fix_date;
        this.score = score;
    }

    public static ReviewDto toReviewDto(ReviewEntity reviewEntity){
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setId(reviewEntity.getId());
        reviewDto.setTitle(reviewEntity.getTitle());
        reviewDto.setContent(reviewEntity.getContent());
        reviewDto.setDate(reviewEntity.getDate());
        reviewDto.setScore(reviewEntity.getScore());
        reviewDto.setFix_date(reviewEntity.getFix_date());

        return reviewDto;
    }
}

