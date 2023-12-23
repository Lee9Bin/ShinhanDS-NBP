//package com.delivery.domain.owner.controller;
//
//import jakarta.servlet.http.HttpSession;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class OwnerHomeController {
//
//    @GetMapping("/ownerSignIn")
//    public String home(HttpSession session, Model model) {
//
//        if (session.getAttribute("loginEmail")!=null){
//            return "html/owner/loginOwnerhome";
//        }
//            return "html/owner/indexOwner";
//    }
//}
