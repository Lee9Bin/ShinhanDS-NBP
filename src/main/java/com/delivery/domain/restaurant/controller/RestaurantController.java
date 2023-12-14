package com.delivery.domain.restaurant.controller;

import com.delivery.domain.restaurant.entiy.Restaurant;
import com.delivery.domain.restaurant.service.RestaurantService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/owner/api/restaurants")
@Controller
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    // 가게 정보 입력 폼을 보여주는 메서드
    @GetMapping("/new")
    public String registerForm(Model model) {
        model.addAttribute("restaurant", new Restaurant());
        return "html/owner/info_registration";
    }

    // 가게 정보를 받아 등록하는 메서드
    @PostMapping("/new")
    public String registerRestaurant(@ModelAttribute Restaurant restaurant, Model model) {
        Long restaurantId = restaurantService.join(restaurant);
        model.addAttribute("restaurantId", restaurantId);
        return "html/owner/owner";
    }

    @GetMapping("/{restaurantId}")
    public String list(Model model,@PathVariable("restaurantId") long restaurantId){
        Restaurant restaurant = restaurantService.findOne(restaurantId);
        model.addAttribute("restaurant",restaurant);
        return "html/owner/info_show";
    }
}
