package com.delivery.domain.storefile.repository;

import com.delivery.domain.storefile.entity.StoreFileEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreFileRepository extends JpaRepository<StoreFileEntity,Long> {
    Optional<StoreFileEntity> findByStoreEntity_Id(Long storeId);
}
