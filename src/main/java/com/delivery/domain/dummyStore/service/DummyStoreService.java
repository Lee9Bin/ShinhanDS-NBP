package com.delivery.domain.dummyStore.service;

import com.delivery.domain.dummyStore.dto.DummyStore;
import com.delivery.domain.dummyStore.entity.DummyStoreEntity;
import com.delivery.domain.dummyStore.repository.DummyStoreRepository;
import com.delivery.domain.owner.entity.OwnerEntity;
import com.delivery.domain.owner.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DummyStoreService {

    private final DummyStoreRepository dummyStoreRepository;
    private final OwnerRepository ownerRepository;

    @Autowired
    public DummyStoreService(DummyStoreRepository dummyStoreRepository, OwnerRepository ownerRepository) {
        this.dummyStoreRepository = dummyStoreRepository;
        this.ownerRepository = ownerRepository;
    }

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

    public DummyStore save(DummyStore dummyStore, Long ownerId) {
        Optional<OwnerEntity> ownerEntityStore = ownerRepository.findById(ownerId);

        if (ownerEntityStore.isPresent()) {
            OwnerEntity ownerEntity = ownerEntityStore.get();

            // DummyStoreEntity로 변환
            DummyStoreEntity dummyStoreEntity = dummyStore.toEntity(ownerEntity);

            // 저장
            DummyStoreEntity savedEntity = dummyStoreRepository.save(dummyStoreEntity);

            // 저장된 엔티티를 DummyStore로 다시 변환하여 반환
            return DummyStore.toDummyStore(savedEntity, ownerEntity);
        }

        // Handle the case when the owner is not found
        throw new IllegalArgumentException("Owner with ID " + ownerId + " not found.");
    }

}