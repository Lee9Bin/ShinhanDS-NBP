package com.delivery.domain.dummyMenu.controller;

import com.delivery.domain.dummyMenu.entity.DummyMenu;
import com.delivery.domain.dummyMenu.repository.DummyMenuRepository;
import com.delivery.domain.dummyStore.entity.DummyStoreEntity;
import com.delivery.domain.dummyStore.repository.DummyStoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/store")
@RequiredArgsConstructor
public class DummyMenuController {

    private final DummyStoreRepository dummyStoreRepository;
    private final DummyMenuRepository dummyMenuRepository;

    @GetMapping("{id}")
    public String detail(@PathVariable Long id, Model model){
        Optional<DummyStoreEntity> targetStore = dummyStoreRepository.findById(id);
        List<DummyMenu> dummyMenuList = dummyMenuRepository.findAllByDummyStoreEntity_Id(id);
        if(targetStore.isPresent()){
            model.addAttribute("store", targetStore.get());
            model.addAttribute("menuList", dummyMenuList);
            return "html/store/detail";
        }

        return null;
    }
}
