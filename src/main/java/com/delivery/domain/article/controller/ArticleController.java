package com.delivery.domain.article.controller;

import com.delivery.domain.article.dto.ArticleDto;
import com.delivery.domain.article.entity.ArticleEntity;
import com.delivery.domain.article.repository.ArticleRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/articles")
@Slf4j
@RequiredArgsConstructor
public class ArticleController {


    private final ArticleRepository articleRepository;

    @GetMapping("/new")
    public String newArticleForm(){return "html/articles/new";}

    @PostMapping("/create")
    public String create(@ModelAttribute ArticleDto form){
        log.info(form.toString());

        ArticleEntity article = form.toEntity();
        log.info(article.toString());

        ArticleEntity saved = articleRepository.save(article);

        log.info(saved.toString());
        return "redirect:/articles/" + saved.getId();
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id= " + id);

        Optional<ArticleEntity> articleEntity = articleRepository.findById(id);

        if(articleEntity.isPresent()){
            model.addAttribute("article", articleEntity.get());
        }
        return "html/articles/show";
    }

    //목록보기
    @GetMapping("")
    public String list(Model model){

        List<ArticleEntity> articleEntityList = articleRepository.findAll();
        log.info(articleEntityList.toString());

       model.addAttribute("articleList", articleEntityList);
        return "html/articles/list";
    }

    //수정하기
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model){

        Optional<ArticleEntity> articleEntity = articleRepository.findById(id);

        if(articleEntity.isPresent()){
            model.addAttribute("article", articleEntity.get());
        }
        return "html/articles/edit";
    }

    @PostMapping ("/{id}/put")
    public String editPut(@ModelAttribute ArticleDto form){

        ArticleEntity article = form.toEntity();
        log.info(form.toString());

        Optional<ArticleEntity> target = articleRepository.findById(article.getId());

        if(target.isPresent()){
            articleRepository.save(article);
        }
        return "redirect:/articles/" + article.getId();
    }

    @GetMapping ("/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr){
        log.info("삭제요청");

        Optional<ArticleEntity> target = articleRepository.findById(id);

        if(target.isPresent()){
            articleRepository.delete(target.get());
            rttr.addFlashAttribute("msg", "게시물삭제");
        }
        return "redirect:/articles";
    }

}
