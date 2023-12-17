package com.delivery.domain.article.controller;

import com.delivery.domain.article.dto.ArticleDto;
import com.delivery.domain.article.entity.ArticleEntity;
import com.delivery.domain.article.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {

    // 스프링부트가 미리 생성해놓은 객체를 가져다가 자동으로 연결한다 -> DI
    @Autowired
    private ArticleRepository articleRepository;

    // 글 생성 뷰 이동
    @GetMapping("/new")
    public String newArticleForm() {
        return "html/articles/new";
    }

    // 글 생성
    @PostMapping("/create")
    public String create(ArticleDto form) {
        // dto에 담겨짐
        // System.out.println(form.toString()); 로깅 바꾸기
        log.info(form.toString());

        // dto가 entity로 변환
        ArticleEntity article = form.toEntity();
//        System.out.println(article.toString()); 로깅 바꾸기
        log.info(article.toString());

        // entity를 repository 인터페이스 이용해서 db저장
        ArticleEntity saved = articleRepository.save(article);
//        System.out.println(saved.toString()); 로깅 바꾸기
        log.info(saved.toString());
        return "redirect:/articles/" + saved.getId();
    }

    // 데이터 1개 조회
    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id = " + id);

        // 1. id로 데이터를 가져옴, id값이 ArticleEntity 타입이 아니여서 Optional로 넣기
        Optional<ArticleEntity> articleEntity = articleRepository.findById(id);
        // Optional대신 뒤에 .orElse(null) 붙이면 밑에 articleEntity만 사용해도 가능

        // 2. 가져온 데이터를 모델에 등록
        // optional이 값을 포함하고 있으면 그 값을, 아니면 null을 사용
        model.addAttribute("article", articleEntity.orElse(null));

        // 3. 보여줄 페이지 설정
        return "html/articles/show";
    }

    // 데이터 목록 조회
    @GetMapping("")
    public String list(Model model){
        // 모든 ArticleEntity 가져온다
        // List 대신 Iterable
        List<ArticleEntity> articleEntityList = articleRepository.findAll();
        log.info(articleEntityList.toString());

        // 가져온 ArticleEntity 묶음을 뷰로 전달
        model.addAttribute("articleList", articleEntityList);
        // 뷰 페이지 설정
        return "html/articles/list";
    }

    // 데이터 수정하기
    // 수정 뷰 보여주기
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model){

        Optional<ArticleEntity> articleEntity = articleRepository.findById(id);
        //ArticleEntity articleEntity = articleRepository.findById(id).orElse(null);
        // 모델에 데이터 등록
        model.addAttribute("article", articleEntity.orElse(null));
        return "/html/articles/edit";
    }

    @PostMapping("/{id}/put")
    public String editPut(ArticleDto form){

        // dto를 entity로 변환
        ArticleEntity article = form.toEntity();
        log.info(form.toString());

        // entity를 db에 저장
        // 2-1 : db에서 기존 데이터를 가져오기
         Optional<ArticleEntity> target = articleRepository.findById(article.getId());
        // 2-2
        if (target != null) {
            articleRepository.save(article); // 엔티티가 db 갱신
        }
        // 수정결과를 뷰로 리다이렉트
        return "redirect:/articles/" + article.getId();
    }


}
