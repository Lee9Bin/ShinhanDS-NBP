package com.delivery.domain.store.service;

import com.delivery.domain.store.dto.StoreDto;
import com.delivery.domain.store.entity.StoreEntity;
import com.delivery.domain.store.repository.StoreRepository;
import com.delivery.domain.owner.entity.OwnerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public List<StoreEntity> searchStoresByName(String searchTerm) {
        return storeRepository.findByNameContainingIgnoreCase(searchTerm);
    }

    // DummyStoreService의 saveStore 메소드 수정
    public void saveStore(StoreDto storeDto, Long ownerId) {
        // OwnerEntity를 사용하도록 수정
        OwnerEntity ownerEntity = new OwnerEntity();
        ownerEntity.setId(ownerId);

        StoreEntity storeEntity = StoreEntity.toDummyStoreEntity(storeDto, ownerEntity);
        storeRepository.save(storeEntity);
    }

}