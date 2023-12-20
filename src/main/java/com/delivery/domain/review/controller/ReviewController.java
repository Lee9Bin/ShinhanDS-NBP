package com.delivery.domain.review.controller;

import com.delivery.domain.review.dto.ReviewDto;
import com.delivery.domain.review.entity.ReviewEntity;
import com.delivery.domain.review.repository.ReviewRepository;
import com.delivery.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;


@Controller // view 템플릿을 반환
@RequestMapping("/review")
@Slf4j
@RequiredArgsConstructor
public class ReviewController {

//    private final ReviewService reviewService;
//
//    @GetMapping("/save")
//    public String saveForm() {
//        return "html/review/save";
//    }
//
//    @PostMapping("/save")
//    public String save(@ModelAttribute ReviewDto reviewDto) throws IOException{
//        System.out.println("reviewDto =" + reviewDto);
//        reviewService.save(reviewDto);
//        return "html/review/index";
//    }
//
//
//    @GetMapping("/")
//    public String findAll(Model model){
//
//            List<ReviewDto> reviewDtoList = reviewService.findAll();
//            model.addAttribute("reviewList", reviewDtoList);
//
//        return "html/review/list";
//    }

//    @PostMapping("/create")
//    public String create(@ModelAttribute ReviewDto form) {
//        // dto에 담겨짐
//        // System.out.println(form.toString()); 로깅 바꾸기
//        log.info(form.toString());
//
//        // dto가 entity로 변환
//        ReviewEntity review = form.toEntity();
////        System.out.println(article.toString()); 로깅 바꾸기
//        log.info(review.toString());
//
//        // entity를 repository 인터페이스 이용해서 db저장
//        ReviewEntity saved = reviewService.save(ReviewDto);
////        System.out.println(saved.toString()); 로깅 바꾸기
//        log.info(saved.toString());
//        return "redirect:/review/" + saved.getId();
//    }
}
