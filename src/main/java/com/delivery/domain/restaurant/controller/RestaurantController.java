package com.delivery.domain.restaurant.controller;

import com.delivery.domain.restaurant.dto.RestaurantDto;
import com.delivery.domain.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/owner/api/restaurants")
@Controller
@RequiredArgsConstructor
@Slf4j
public class RestaurantController {
    private final RestaurantService restaurantService;

    // 가게 정보 입력 폼
    @GetMapping("/new")
    public String registerForm() {
        return "html/owner/info_registration";
    }

    @PostMapping("/new")
    public String registerRestaurant(@ModelAttribute RestaurantDto restaurantDto, Model model) {
        Long restaurantId = restaurantService.save(restaurantDto);
        model.addAttribute("restaurantId", restaurantId);
        return "html/owner/owner";
    }

    //가게 수정 폼
    @GetMapping("/{restaurantId}")
    public String list(Model model,@PathVariable("restaurantId") long restaurantId){
        RestaurantDto restaurantDto = restaurantService.findById(restaurantId);
        model.addAttribute("restaurant", restaurantDto);
        return "html/owner/info_show";
    }

    @PostMapping("/{restaurantId}")
    //RedirectAttributes -> 일회성 메세지 넘기기
    public String update(@ModelAttribute RestaurantDto restaurantDto, RedirectAttributes rttr){
        RestaurantDto update = restaurantService.update(restaurantDto);
        rttr.addFlashAttribute("ssg","성공적으로 수정");
        return "redirect:/owner";
    }
}
