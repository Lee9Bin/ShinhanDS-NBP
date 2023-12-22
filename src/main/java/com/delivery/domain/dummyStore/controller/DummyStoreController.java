package com.delivery.domain.dummyStore.controller;

import com.delivery.domain.dummyStore.entity.DummyStoreEntity;
import com.delivery.domain.dummyStore.service.DummyStoreService;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class DummyStoreController {
    private final DummyStoreService dummyStoreService;

    @GetMapping("/searchResults")
    public String searchResultsPage(@RequestParam String searchTerm, Model model) {
        List<DummyStoreEntity> searchResults = dummyStoreService.searchStoresByName(searchTerm);
        model.addAttribute("searchResults", searchResults);
        return "/html/store/StoreFindResult"; // 검색 결과를 보여줄 HTML 파일명
    }

    // 점주 가게 등록 폼
    @GetMapping("/owner/store/new")
    public String registed(){
        return "/layouts/owner/regist";
    }



}

