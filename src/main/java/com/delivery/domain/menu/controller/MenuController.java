package com.delivery.domain.menu.controller;

import com.delivery.domain.menu.entity.Menu;
import com.delivery.domain.menu.repository.MenuRepository;
import com.delivery.domain.menu.service.MenuService;
import com.delivery.domain.restaurant.entity.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;
    private final MenuRepository menuRepository;
    @GetMapping("/owner/api/menu/new")
    public String registerForm(Model model) {
        model.addAttribute("menu", new Menu());
        return "html/owner/menu_registration";
    }
    @PostMapping("/owner/api/menu/new")
    public String addMenu(@ModelAttribute Menu menu, Model model){
        model.addAttribute("menu", menu);
        menuService.join(menu);
        return "redirect: /owner";
    }
//    @GetMapping("/owner/api/menu/{menu}")
//    public String list(Model model,@PathVariable("menuId") Long menuId){
//        Menu menu = menuService.findOne(menuId);
//        model.addAttribute("menu",menu);
//        return "html/owner/info_show2";
//    }






}
