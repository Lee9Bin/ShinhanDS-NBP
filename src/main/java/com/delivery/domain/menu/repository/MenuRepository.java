package com.delivery.domain.menu.repository;

import com.delivery.domain.article.entity.ArticleEntity;
import com.delivery.domain.menu.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {

}
