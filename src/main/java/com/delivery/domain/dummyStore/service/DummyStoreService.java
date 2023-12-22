package com.delivery.domain.dummyStore.service;

import com.delivery.domain.dummyStore.entity.DummyStoreEntity;
import com.delivery.domain.dummyStore.repository.DummyStoreRepository;
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

}