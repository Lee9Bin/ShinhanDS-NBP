package com.delivery.domain.mypage.controller;


import com.delivery.domain.article.entity.ArticleEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller // view 템플릿을 반환
@RequestMapping("/mypage")
@Slf4j
@RequiredArgsConstructor // final로 명시된 필드를 DI 적용해준다, autowired보다 좋다~~~~~
public class MypageController {

    @GetMapping("/orderlist")
    public String orderlist(Model model){

        return "html/mypage/orderlist";
    }

    @GetMapping("/info")
    public String info(Model model){

        return "html/mypage/info";
    }
    @GetMapping("/")
    public String mypage(Model model) {

        return "html/mypage/mypage";
    }
    @GetMapping("/bookmark")
    public String bookmark(Model model){

        return "html/mypage/bookmark";
    }
    @GetMapping("/recharge")
    public String recharge(Model model){

        return "html/mypage/recharge";
    }
    @GetMapping("/setting")
    public String setting(Model model){

        return "html/mypage/setting";
    }

}
