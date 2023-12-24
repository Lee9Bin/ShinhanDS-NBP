package com.delivery.domain.store.service;

import com.delivery.domain.owner.entity.OwnerEntity;
import com.delivery.domain.owner.repository.OwnerRepository;
import com.delivery.domain.store.dto.StoreDto;
import com.delivery.domain.store.entity.StoreEntity;
import com.delivery.domain.store.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final OwnerRepository ownerRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository, OwnerRepository ownerRepository) {
        this.storeRepository = storeRepository;
        this.ownerRepository = ownerRepository;
    }

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

    public StoreDto save(StoreDto store, Long ownerId) {
        Optional<OwnerEntity> ownerEntityStore = ownerRepository.findById(ownerId);

        if (ownerEntityStore.isPresent()) {
            OwnerEntity ownerEntity = ownerEntityStore.get();

            // DummyStoreEntity로 변환
            StoreEntity storeEntity = store.toEntity(ownerEntity);

            // 저장
            StoreEntity savedEntity = storeRepository.save(storeEntity);

            // 저장된 엔티티를 DummyStore로 다시 변환하여 반환
            return StoreDto.toDummyStore(savedEntity, ownerEntity);
        }

        // Handle the case when the owner is not found
        throw new IllegalArgumentException("Owner with ID " + ownerId + " not found.");
    }

}