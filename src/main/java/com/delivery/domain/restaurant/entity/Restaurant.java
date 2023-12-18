package com.delivery.domain.restaurant.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Restaurant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long id;

//  Fk 점주 아이디

    private String name;
    private String phone;
    private String address;
    private String closeDay;
    private String openTime;
    private String closeTime;
    private String content;
    private String picture;
    private String category;
    private String storeRegister;

//    private List<Menu> menuList = new ArrayList<>();

}
