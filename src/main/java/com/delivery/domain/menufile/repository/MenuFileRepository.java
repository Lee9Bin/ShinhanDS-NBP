package com.delivery.domain.menufile.repository;

import com.delivery.domain.menufile.entity.MenuFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuFileRepository extends JpaRepository<MenuFileEntity,Long> {
}