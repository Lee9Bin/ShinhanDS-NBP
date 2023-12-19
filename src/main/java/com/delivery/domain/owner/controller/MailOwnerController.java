package com.delivery.domain.owner.controller;

import com.delivery.domain.owner.service.MailOwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MailOwnerController {
    private final MailOwnerService mailOwnerService;

    @GetMapping("/mailOwner")
    public String MailPage(){
        return "/html/owner/mailOwner";
    }

    @ResponseBody
    @PostMapping("/mailOwner")
    public String MailSend(String ownerEmail){

        int number = mailOwnerService.sendMail(ownerEmail);

        String num = "" + number;

        return num;
    }
}
