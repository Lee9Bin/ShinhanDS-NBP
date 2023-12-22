package com.delivery.domain.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberHomeController {

    @GetMapping("/")
    public String home(HttpSession session, Model model) {

        if (session.getAttribute("loginEmail") != null) {
            return "redirect:/customer/";
        }
        return "html/member/login";
    }
}
