package com.delivery.domain.review_comment.dto;


import com.delivery.domain.review.entity.ReviewEntity;
import com.delivery.domain.review_comment.entity.RecommentEntity;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class RecommentDto {
    private Long id;
    private Long owner_id;
    private Long review_id;
    private String date;
    private String fix_date;
    private String content;

    public RecommentEntity toEntity() {
        return new RecommentEntity(id, owner_id, review_id, date, fix_date, content);
    }
}
