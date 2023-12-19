package com.delivery.domain.review.dto;

import com.delivery.domain.review.entity.ReviewEntity;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
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
}

