//package com.delivery.domain.dummyStore.controller;
//
//import com.delivery.domain.dummyStore.entity.DummyStoreEntity;
//import com.delivery.domain.dummyStore.repository.DummyStoreRepository;
//import jakarta.servlet.http.HttpSession;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import java.util.List;
//
//
//@Controller
//@RequestMapping("/customer")
//@Slf4j
//@RequiredArgsConstructor
//public class DummyStoreController {
//    private final DummyStoreRepository dummyStoreRepository;
//
//
////    @GetMapping("/")
////    public String test(Model model) {
////
////        List<DummyStoreEntity> dummyStoreEntity = dummyStoreRepository.findAll();
////        session.setAttribute("stores", dummyStoreEntity);
////        List<String> store = (List<String>) session.getAttribute("stores");
////        model.addAttribute("stores", store);
////
////        log.info("이동하기 loginEmail: " + session.getAttribute("loginEmail"));
////        return "html/layouts/menu";
////    }
//
////    @GetMapping("/moreStores")
////    public String getMoreStores(Model model) {
////        // DummyStoreService를 이용하여 추가적인 가게 데이터를 가져와 모델에 추가
////
////        log.info("test! = " + additionalStores.toString());
////        model.addAttribute("stores", additionalStores);
////        return "html/customer/test"; // 이 부분을 수정하여 레이아웃을 변경할 수 있습니다.
////    }
//}
