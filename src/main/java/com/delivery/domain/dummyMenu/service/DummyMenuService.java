package com.delivery.domain.dummyMenu.service;

import com.delivery.domain.dummyMenu.dto.DummyMenuDto;
import com.delivery.domain.dummyMenu.entity.DummyMenu;
import com.delivery.domain.dummyMenu.repository.DummyMenuRepository;
import com.delivery.domain.dummyStore.dto.DummyStore;
import com.delivery.domain.dummyStore.entity.DummyStoreEntity;
import com.delivery.domain.dummyStore.repository.DummyStoreRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class DummyMenuService {

    private final DummyMenuRepository dummyMenuRepository;
    private final DummyStoreRepository dummyStoreRepository;

    //메뉴 저장
    public void save(List<DummyMenuDto> dummyMenuDtoList, Long dummyStoreId){
        Optional<DummyStoreEntity> targetStore = dummyStoreRepository.findById(dummyStoreId);

        if(targetStore.isPresent()){
            for(DummyMenuDto dummyMenuDto : dummyMenuDtoList){
                DummyMenu entity = DummyMenu.toEntity(dummyMenuDto, targetStore.get());
                dummyMenuRepository.save(entity);
            }
        }
    }

    //메뉴 찾기
//    public DummyMenuDto findById(Long id) {
//        Optional<DummyMenu> optionalDummyMenu = dummyMenuRepository.findById(id);
//
//        if(optionalDummyMenu.isPresent()){
//            return DummyMenuDto.toDummyMenuDto(optionalDummyMenu.get(),);
//        }
//    }
}
