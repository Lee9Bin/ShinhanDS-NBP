package com.delivery.controller;

import com.delivery.domain.owner.service.OwnerService;
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
public class OwnerController {

    private final OwnerService ownerService;

    @GetMapping(value = "")
    public String ownerHome(Model model){
        log.info("ownerHome");
        return "layouts/owner/ownerNewMain";
    }


}
