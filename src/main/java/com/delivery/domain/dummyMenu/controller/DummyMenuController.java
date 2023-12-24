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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/store")
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
        return "redirect:/store/{id}/menu/new";
    }

    // @GetMapping("/menu/new/{id}")
    // public String menuSaveForm(@PathVariable Long id, Model model) {
    //     model.addAttribute("storeId", id);
    //     return "html/owner/menu_registration";
    // }
    //
    // @PostMapping("/menu/new/{id}")
    // public String menuSave(@PathVariable Long id, @RequestBody List<DummyMenuDto> dummyMenuDtoList, Model model) {
    //     for (DummyMenuDto dummyMenuDto : dummyMenuDtoList) {
    //         // 여기서 받아온 데이터로 메뉴를 저장하거나 다른 작업을 수행할 수 있습니다.
    //         // 예시로 저장만 하는 코드를 추가했습니다.
    //         System.out.println(dummyMenuDto.toString());
    //     }
    //     return "html/owner/menu_registration";


    @GetMapping("{id}")
    public String detail(@PathVariable Long id, Model model) {
        Optional<DummyStoreEntity> targetStore = dummyStoreRepository.findById(id);
        List<DummyMenu> dummyMenuList = dummyMenuRepository.findAllByDummyStoreEntity_Id(id);

        if (targetStore.isPresent()) {
            model.addAttribute("store", targetStore.get());
            model.addAttribute("menuList", dummyMenuList);
//            model.addAttribute("base64Image", storePicturePath);
            return "html/store/detail";
        }
        // 예시로 null을 반환하였습니다. 실제 상황에 맞게 수정하세요.
        return null;
    }

    private String encodeImageToBase64(String picturePath) throws IOException {
        Path imagePath = Paths.get("path/to/your/image/directory", picturePath);
        byte[] imageBytes = Files.readAllBytes(imagePath);
        return Base64.getEncoder().encodeToString(imageBytes);
    }
}
