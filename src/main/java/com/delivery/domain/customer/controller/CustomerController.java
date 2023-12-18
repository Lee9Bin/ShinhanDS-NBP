package com.delivery.domain.customer.controller;


import com.delivery.domain.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
@Slf4j
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping("/mypage")
    public String newCustomerMypage(){return "html/customer/mypage";}

    @GetMapping("/bookmark")
    public String newCustomerBookmark(){return "html/customer/bookmark";}

    @GetMapping("/info")
    public String newCustomerInfo(){return "html/customer/info";}

    @GetMapping("/orderlist")
    public String newCustomerOrderList(){return "html/customer/orderlist";}

    @GetMapping("/recharge")
    public String newCustomerRecharge(){return "html/customer/recharge";}
    @GetMapping("/review")
    public String newCustomerReview(){return "html/customer/review";}

    @GetMapping("/setting")
    public String newCustomerSetting(){return "html/customer/setting";}


}
