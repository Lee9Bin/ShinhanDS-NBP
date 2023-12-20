package com.delivery.domain.review.service;

import com.delivery.domain.review.dto.ReviewDto;
import com.delivery.domain.review.entity.ReviewEntity;
import com.delivery.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public void save(ReviewDto reviewDto) throws IOException{
        ReviewEntity reviewEntity = ReviewEntity.toSaveEntity(reviewDto);
        reviewRepository.save(reviewEntity);
    }

    @Transactional
    public List<ReviewDto> findAll(){
        List<ReviewEntity> reviewEntityList = reviewRepository.findAll();
        List<ReviewDto> reviewDtoList = new ArrayList<>();
        for(ReviewEntity reviewEntity: reviewEntityList){
            reviewDtoList.add(ReviewDto.toReviewDto(reviewEntity));
        }
        return reviewDtoList;
    }

    @Transactional
    public ReviewDto findById(Long id){
        Optional<ReviewEntity> optionalReviewEntity = reviewRepository.findById(id);
        if(optionalReviewEntity.isPresent()){
            ReviewEntity reviewEntity = optionalReviewEntity.get();
            ReviewDto reviewDto = ReviewDto.toReviewDto(reviewEntity);
            return reviewDto;
        }else {
            return null;
        }
    }
}
