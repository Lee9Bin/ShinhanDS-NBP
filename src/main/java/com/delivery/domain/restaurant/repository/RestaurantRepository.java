package com.delivery.domain.restaurant.repository;

import com.delivery.domain.restaurant.entity.Restaurant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantRepository {

    @PersistenceContext
    EntityManager em;

    public Long save(Restaurant restaurant){
        em.persist(restaurant);
        return restaurant.getId();
    }

    public Restaurant findOne(Long id){
        return em.find(Restaurant.class, id);
    }
}
