package com.delivery.domain.customer.repository;

import com.delivery.domain.article.entity.ArticleEntity;
import com.delivery.domain.customer.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

}
