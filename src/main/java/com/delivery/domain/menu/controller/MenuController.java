package com.delivery.domain.menu.controller;

import com.delivery.domain.menu.dto.MenuDto;
import com.delivery.domain.menu.entity.MenuEntity;
import com.delivery.domain.menu.repository.MenuRepository;
import com.delivery.domain.menu.service.MenuService;
import com.delivery.domain.store.entity.StoreEntity;
import com.delivery.domain.store.repository.StoreRepository;
import com.delivery.domain.store.service.StoreService;
import jakarta.servlet.http.HttpSession;
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
public class MenuController {

    private final MenuService menuService;
    private final StoreService storeService;


    //메뉴 등록 폼
    @GetMapping("/menu/new")
    public String menuSaveForm(Model model) {
        // model.addAttribute();
        return "html/owner/menu_registration";

    }

    @PostMapping("/menu/new")
    public String menuSave(HttpSession session,@RequestBody List<MenuDto> menuDtoList, Model model) {
        for (MenuDto menuDto : menuDtoList) {
            // 여기서 받아온 데이터로 메뉴를 저장하거나 다른 작업을 수행할 수 있습니다.
            // 예시로 저장만 하는 코드를 추가했습니다.
            System.out.println("메뉴 리스트입니다."+menuDto.toString());
        }
        return "redirect:/owner/";
    }
    // @GetMapping("{id}")
    // public String detail(@PathVariable Long id, Model model) {
    //     Optional<StoreEntity> targetStore = storeService.findById(id);
    //     List<MenuEntity> menuListEntity = menuRepository.findAllByStoreEntity_Id(id);
    //
    //     if (targetStore.isPresent()) {
    //         model.addAttribute("store", targetStore.get());
    //         model.addAttribute("menuList", menuListEntity);
    //        // model.addAttribute("base64Image", storePicturePath);
    //         return "html/store/detail";
    //     }
    //     // 예시로 null을 반환하였습니다. 실제 상황에 맞게 수정하세요.
    //     return null;
    // }

    private String encodeImageToBase64(String picturePath) throws IOException {
        Path imagePath = Paths.get("path/to/your/image/directory", picturePath);
        byte[] imageBytes = Files.readAllBytes(imagePath);
        return Base64.getEncoder().encodeToString(imageBytes);
    }
}
