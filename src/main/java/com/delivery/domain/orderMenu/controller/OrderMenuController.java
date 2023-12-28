package com.delivery.domain.orderMenu.controller;

import com.delivery.domain.orderMenu.repository.OrderMenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class OrderMenuController {

    private final OrderMenuRepository orderMenuRepository;

    @PostMapping("/order/orderContent")
    public String processOrder(@RequestParam List<String> orderRequests, Model model)  {
//        model.addAttribute()
        orderRequests.forEach(a -> log.info("데이터가 들어와라 - " + a.toString()));
        model.addAttribute("orderMenu", orderRequests);



        // 성공적으로 처리되었다는 응답 반환
        return "html/order/orderPay";
    }
}