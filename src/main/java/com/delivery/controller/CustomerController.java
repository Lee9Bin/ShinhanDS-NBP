package com.delivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/customer")
@Controller
public class CustomerController {


    @GetMapping("/")
    public String test(){
        return "html/customer/test";
    }
}
