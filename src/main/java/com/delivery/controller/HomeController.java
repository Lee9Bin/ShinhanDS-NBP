package com.delivery.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owner")
@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeController {
    @GetMapping(value = "/customer")
    public String customerHome(){
        log.info("customerHome");
        return "html/customer/customer";
    }

    @GetMapping(value = "")
    public String ownerHome(Model model){
        log.info("ownerHome");
        return "html/owner/owner";
    }

    @GetMapping("/test")
    public String testLayout(){
        return "html/customer/customer1";
    }



    }
