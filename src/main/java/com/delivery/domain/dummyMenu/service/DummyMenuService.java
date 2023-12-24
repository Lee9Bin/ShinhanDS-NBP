package com.delivery.domain.dummyMenu.service;

import com.delivery.domain.dummyMenu.dto.DummyMenuDto;
import com.delivery.domain.dummyMenu.entity.DummyMenu;
import com.delivery.domain.dummyMenu.repository.DummyMenuRepository;
import com.delivery.domain.dummyStore.entity.DummyStoreEntity;
import com.delivery.domain.dummyStore.repository.DummyStoreRepository;
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
public class DummyMenuService {

    private final DummyMenuRepository dummyMenuRepository;
    private final DummyStoreRepository dummyStoreRepository;


    // 메뉴 저장
    public DummyMenuDto save(List<DummyMenuDto> dummyMenuDtoList, Long storeId) {
        Optional<DummyStoreEntity> targetStore = dummyStoreRepository.findById(storeId);

        if (targetStore.isPresent()) {
            for (DummyMenuDto dummyMenuDto : dummyMenuDtoList) {
                // DummyMenuDto에서 DummyMenu 엔터티로 변환하는 메서드 사용
                DummyMenu entity = dummyMenuDto.toEntity(targetStore.orElse(null)); // orElse 사용하여 null 체크
                dummyMenuRepository.save(entity);
            }
        }
        return null;
    }
}
