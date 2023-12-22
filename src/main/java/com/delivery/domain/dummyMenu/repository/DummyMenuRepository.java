package com.delivery.domain.dummyMenu.repository;

import com.delivery.domain.dummyMenu.entity.DummyMenu;
import com.delivery.domain.orderDelivery.entiy.OrderDelivery;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DummyMenuRepository extends JpaRepository<DummyMenu, Long> {
    List<DummyMenu> findAllByDummyStoreEntity_Id(Long storeId);
}
