package com.delivery.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {
    @GetMapping(value = "/customer")
    public String customerHome(){
        log.info("customerHome");
        return "html/customer/customer";
    }

    @GetMapping(value = "/owner")
    public String ownerHome(){
        log.info("ownerHome");
        return "html/owner/owner";
    }

    @GetMapping("/test")
    public String testLayout(){
        return "html/customer/customer1";
    }

    }
