/*
package com.delivery.domain.article.api;

import com.delivery.domain.article.dto.ArticleDto;
import com.delivery.domain.article.entity.ArticleEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@Slf4j
@RequiredArgsConstructor
public class ArticleApiController {

    private final ArticleService articleService;

    //모든 API
    @GetMapping("/")
    public List<ArticleEntity> index(){
        return articleService.index();
    }

    //단일 API
    @GetMapping("/{id}")
    public Optional<ArticleEntity> show(@PathVariable Long id){return articleService.show(id);}

    @PostMapping("/")
    public ResponseEntity<ArticleEntity> create(@RequestBody ArticleDto dto){
        ArticleEntity created =articleService.create(dto);
        return (created != null)?
                ResponseEntity.status(HttpStatus.OK).body(created);
        ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
                }
}
*/
