package com.delivery.domain.dummyStore.repository;

import com.delivery.domain.dummyStore.entity.DummyStoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DummyStoreRepository extends JpaRepository<DummyStoreEntity, Long> {
    List<DummyStoreEntity> findAll();

    // 대소문자 구별하지 않고 검색
    List<DummyStoreEntity> findByNameContainingIgnoreCase(String name);

}
