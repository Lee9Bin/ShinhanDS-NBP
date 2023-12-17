package com.delivery.domain.restaurant.controller;

import com.delivery.domain.restaurant.dto.RestaurantCreateDto;
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
        model.addAttribute("restaurant", new RestaurantCreateDto());
        return "html/owner/info_registration";
    }

    // 가게 정보를 받아 등록하는 메서드
    @PostMapping("/new")
    public String registerRestaurant(@ModelAttribute RestaurantCreateDto restaurantCreateDto, Model model) {
        Restaurant restaurant = Restaurant.toEntity(restaurantCreateDto);
        Long restaurantId = restaurantService.join(restaurant);
        model.addAttribute("restaurantId", restaurantId);
        return "html/owner/owner";
    }

    @GetMapping("/{restaurantId}")
    public String list(Model model,@PathVariable("restaurantId") long restaurantId){
        Restaurant restaurant = restaurantService.findById(restaurantId);
        RestaurantCreateDto dto = RestaurantCreateDto.toDto(restaurant);
        model.addAttribute("restaurant",dto);
        return "html/owner/info_show";
    }

    @PostMapping("/{restaurantId}")
    public String update(@ModelAttribute RestaurantCreateDto restaurantCreateDto, Model model){
        Restaurant entity = Restaurant.toEntity(restaurantCreateDto);
        System.out.println(entity);
        restaurantService.join(entity);
        model.addAttribute("restaurant",entity);
        return "html/owner/owner";
    }
}
