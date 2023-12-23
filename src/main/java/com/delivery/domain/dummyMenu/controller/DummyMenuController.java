package com.delivery.domain.dummyMenu.controller;

import com.delivery.domain.dummyMenu.dto.DummyMenuDto;
import com.delivery.domain.dummyMenu.entity.DummyMenu;
import com.delivery.domain.dummyMenu.repository.DummyMenuRepository;
import com.delivery.domain.dummyMenu.service.DummyMenuService;
import com.delivery.domain.dummyStore.entity.DummyStoreEntity;
import com.delivery.domain.dummyStore.repository.DummyStoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("owner/store")
@RequiredArgsConstructor
@Slf4j
public class DummyMenuController {

    private final DummyStoreRepository dummyStoreRepository;
    private final DummyMenuRepository dummyMenuRepository;
    private final DummyMenuService dummyMenuService;

    @GetMapping("/{id}/menu/new")
    public String menuSaveForm(Model model, @PathVariable Long id) {
        Optional<DummyStoreEntity> targetStore = dummyStoreRepository.findById(id);

        // targetStore가 존재하면 모델에 추가
        targetStore.ifPresent(store -> model.addAttribute("targetStore", store));

        // 빈 DummyMenuDto를 생성하여 모델에 추가
        model.addAttribute("dummyMenuDtoList", List.of(new DummyMenuDto()));

        return "html/owner/menu_registration";
    }

    @PostMapping("/{id}/menu/new")
    public String menuSave(@ModelAttribute("dummyMenuDtoList") List<DummyMenuDto> dummyMenuDtoList,
                           @PathVariable Long id) {
        // DummyMenuService를 사용하여 메뉴 저장
        dummyMenuService.save(dummyMenuDtoList, id);

        // 저장 후 다시 메뉴 등록 페이지로 이동
        return "redirect:/owner/store/{id}/menu/new";
    }
//    @PostMapping("/menu/new")
//    public String menuSave(@ModelAttribute ArrayList<DummyMenuDto> dummyMenuDtoList, Model model){
//        for(DummyMenuDto dummyMenuDto : dummyMenuDtoList){
//            System.out.println(dummyMenuDto.toString());
//        }
//        return "html/owner/menu_registration";
//    }

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
