package com.delivery.domain.comment.service;

import com.delivery.domain.article.repository.ArticleRepository;
import com.delivery.domain.comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository repository;
    @Autowired
    private ArticleRepository articleRepository;



}
