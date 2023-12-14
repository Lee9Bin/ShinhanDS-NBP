package com.delivery.domain.restaurant.controller;

import com.delivery.domain.restaurant.entiy.Restaurant;
import com.delivery.domain.restaurant.service.RestaurantService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    // 가게 정보 입력 폼을 보여주는 메서드
    @GetMapping("/owner/api/restaurants/new")
    public String registerForm(Model model) {
        model.addAttribute("restaurant", new Restaurant());
        return "html/owner/info_registration";
    }

    // 가게 정보를 받아 등록하는 메서드
    @PostMapping("/owner/api/restaurants/new")
    public String registerRestaurant(@ModelAttribute Restaurant restaurant, Model model) {
        model.addAttribute("restaurant", restaurant);
        restaurantService.join(restaurant);
        return "redirect:/owner";
    }

    @GetMapping("/owner/api/restaurants/{restaurant}")
    public String list(Model model,@PathVariable("restaurantId") Long restaurantId){
        Restaurant restaurant = restaurantService.findOne(restaurantId);
        model.addAttribute("restaurant",restaurant);
        return "html/owner/info_show";
    }
}
