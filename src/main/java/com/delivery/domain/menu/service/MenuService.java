package com.delivery.domain.menu.service;

import com.delivery.domain.menu.dto.MenuDto;
import com.delivery.domain.menu.entity.MenuEntity;
import com.delivery.domain.menu.repository.MenuRepository;
import com.delivery.domain.store.entity.StoreEntity;
import com.delivery.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final StoreRepository storeRepository;


    // 메뉴 저장
    public MenuDto save(List<MenuDto> menuDtoList, Long storeId) {
        Optional<StoreEntity> targetStore = storeRepository.findById(storeId);

        if (targetStore.isPresent()) {
            for (MenuDto menuDto : menuDtoList) {
                // DummyMenuDto에서 DummyMenu 엔터티로 변환하는 메서드 사용
                MenuEntity entity = menuDto.toEntity(targetStore.orElse(null)); // orElse 사용하여 null 체크
                menuRepository.save(entity);
            }
        }
        return null;
    }
}
