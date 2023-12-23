package com.delivery.domain.dummyStore.service;

import com.delivery.domain.dummyStore.dto.DummyStore;
import com.delivery.domain.dummyStore.entity.DummyStoreEntity;
import com.delivery.domain.dummyStore.repository.DummyStoreRepository;
import com.delivery.domain.owner.entity.OwnerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DummyStoreService {

    private final DummyStoreRepository dummyStoreRepository;

    public List<DummyStoreEntity> searchStoresByName(String searchTerm) {
        return dummyStoreRepository.findByNameContainingIgnoreCase(searchTerm);
    }

    // DummyStoreService의 saveStore 메소드 수정
    public void saveStore(DummyStore dummyStore, Long ownerId) {
        // OwnerEntity를 사용하도록 수정
        OwnerEntity ownerEntity = new OwnerEntity();
        ownerEntity.setId(ownerId);

        DummyStoreEntity dummyStoreEntity = DummyStoreEntity.toDummyStoreEntity(dummyStore, ownerEntity);
        dummyStoreRepository.save(dummyStoreEntity);
    }

}