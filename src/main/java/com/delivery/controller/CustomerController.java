package com.delivery.controller;


import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/customer")
@Controller
@Slf4j
@RequiredArgsConstructor
public class CustomerController {



    @GetMapping("/")
    public String test(HttpSession session, Model model){



        // 로그 찍어보기

//        List<DummyStoreEntity> dummyStoreEntity = dummyStoreRepository.findAll();
//        log.info(dummyStoreEntity.toString());
//        session.setAttribute("stores", dummyStoreEntity);
//        List<String> store = (List<String>) session.getAttribute("stores");
//        model.addAttribute("stores", store);




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
