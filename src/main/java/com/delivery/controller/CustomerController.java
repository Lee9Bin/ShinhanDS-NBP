package com.delivery.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/customer")
@Controller
@Slf4j
public class CustomerController {


    @GetMapping("/")
    public String test(HttpSession session, Model model){
        String loginName = (String) session.getAttribute("loginName");

        boolean isLoggedIn = true;

        if(loginName == null){

            System.out.println("아이디 틀렸다~!");
            isLoggedIn = false;
            return "html/customer/test";
        }

        model.addAttribute("loginName", loginName);

        model.addAttribute("loggedIn", isLoggedIn);

//        session.setAttribute("loginName", loginName);

        log.info("이동하기 loginEmail: " + session.getAttribute("loginEmail"));
        return "html/customer/test";

    }
}
