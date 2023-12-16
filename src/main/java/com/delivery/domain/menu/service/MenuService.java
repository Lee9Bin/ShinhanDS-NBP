package com.delivery.domain.menu.service;


import com.delivery.domain.menu.entity.Menu;
import com.delivery.domain.menu.repository.MenuRepository;
import com.delivery.domain.restaurant.entity.Restaurant;
import com.delivery.domain.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    @Transactional
    public Long join(Menu menu) {
        menuRepository.save(menu);
        return menu.getId();
    }



}
