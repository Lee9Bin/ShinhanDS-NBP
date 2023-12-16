package com.delivery.domain.menu.repository;

import com.delivery.domain.menu.entity.Menu;
import com.delivery.domain.restaurant.entity.Restaurant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Long>{

}
