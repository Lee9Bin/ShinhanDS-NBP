package com.delivery.domain.member.controller;

import com.delivery.domain.member.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MailController {
    private final MailService mailService;

    @GetMapping("/mail")
    public String MailPage(){
        return "html/member/mail";
    }

    @ResponseBody
    @PostMapping("/mail")
    public String MailSend(String memberEmail){

        int number = mailService.sendMail(memberEmail);

        String num = "" + number;

        return num;
    }
}
