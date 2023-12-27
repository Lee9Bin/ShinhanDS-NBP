package com.delivery.domain.menu.service;

import com.delivery.domain.menu.dto.MenuDto;
import com.delivery.domain.menu.entity.MenuEntity;
import com.delivery.domain.menu.repository.MenuRepository;
import com.delivery.domain.menufile.repository.MenuFileRepository;
import com.delivery.domain.menufile.service.MenuFileService;
import com.delivery.domain.store.entity.StoreEntity;
import com.delivery.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final StoreRepository storeRepository;
    private final MenuFileService menuFileService;
    private final MenuFileRepository menuFileRepository;


    // 메뉴 저장
    public void save(MenuDto menuDto, Long storeId, MultipartFile multipartFile) throws IOException {
        Optional<StoreEntity> targetStore = storeRepository.findById(storeId);

        if(targetStore.isPresent()){
            MenuEntity menuEntity = MenuEntity.toEntity(menuDto, targetStore.get());
            menuRepository.save(menuEntity);
            menuFileService.saveFile(multipartFile, menuEntity);
        }
    }

    //해당 가게 메뉴 조회
    public List<MenuDto> findAllByStoreEntity_Id(Long storeId){
        List<MenuEntity> menuEntityList = menuRepository.findAllByStoreEntity_Id(storeId);
        List<MenuDto> menuDtoList = new ArrayList<>();

        for (MenuEntity menuEntity : menuEntityList){
            menuDtoList.add(MenuDto.toMenuDto(menuEntity, storeRepository.findById(storeId).get(), menuFileRepository.findByMenuEntity_Id(menuEntity.getId()).get()));
        }

        return menuDtoList;
    }

}
