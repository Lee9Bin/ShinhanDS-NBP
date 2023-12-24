package com.delivery.domain.menu.repository;

import com.delivery.domain.menu.entity.MenuEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {

    // List<StoreMenuEntity> findAllByDummyStoreEntity_Idse(Long storeId);
}
