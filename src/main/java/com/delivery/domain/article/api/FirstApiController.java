package com.delivery.domain.article.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // RestAPI용 컨트롤러 -> JSON을 반환한다
@RequestMapping("/api")
public class FirstApiController {

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
