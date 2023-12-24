package com.delivery.domain.dummyMenu.controller;

import com.delivery.domain.dummyMenu.dto.DummyMenuDto;
import com.delivery.domain.dummyMenu.entity.DummyMenu;
import com.delivery.domain.dummyStore.entity.DummyStoreEntity;
import com.delivery.domain.dummyStore.repository.DummyStoreRepository;
import com.delivery.domain.dummyMenu.repository.DummyMenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/store")
@RequiredArgsConstructor
public class DummyMenuController {

    private final DummyStoreRepository dummyStoreRepository;
    private final DummyMenuRepository dummyMenuRepository;

    @GetMapping("/menu/new/{id}")
    public String menuSaveForm(@PathVariable Long id, Model model) {
        model.addAttribute("storeId", id);
        return "html/owner/menu_registration";
    }

    @PostMapping("/menu/new/{id}")
    public String menuSave(@PathVariable Long id, @RequestBody List<DummyMenuDto> dummyMenuDtoList, Model model) {
        for (DummyMenuDto dummyMenuDto : dummyMenuDtoList) {
            // 여기서 받아온 데이터로 메뉴를 저장하거나 다른 작업을 수행할 수 있습니다.
            // 예시로 저장만 하는 코드를 추가했습니다.
            System.out.println(dummyMenuDto.toString());
        }
        return "html/owner/menu_registration";
    }

    @GetMapping("{id}")
    public String detail(@PathVariable Long id, Model model) {
        Optional<DummyStoreEntity> targetStore = dummyStoreRepository.findById(id);
        List<DummyMenu> dummyMenuList = dummyMenuRepository.findAllByDummyStoreEntity_Id(id);
        if (targetStore.isPresent()) {
            model.addAttribute("store", targetStore.get());
            model.addAttribute("menuList", dummyMenuList);
            return "html/store/detail";
        }
        // 예시로 null을 반환하였습니다. 실제 상황에 맞게 수정하세요.
        return null;
    }
}
