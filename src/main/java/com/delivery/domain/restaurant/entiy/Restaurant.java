package com.delivery.domain.restaurant.entiy;

import com.delivery.domain.restaurant.dto.RestaurantCreateDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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


    public static Restaurant toEntity(RestaurantCreateDto RestaurantCreateDto){
        return new Restaurant(RestaurantCreateDto.getId(),
                RestaurantCreateDto.getName(),
                RestaurantCreateDto.getPhone(),
                RestaurantCreateDto.getAddress(),
                RestaurantCreateDto.getCloseDay(),
                RestaurantCreateDto.getOpenTime(),
                RestaurantCreateDto.getCloseTime(),
                RestaurantCreateDto.getContent(),
                RestaurantCreateDto.getPicture(),
                RestaurantCreateDto.getCategory(),
                RestaurantCreateDto.getStoreRegister());
    }
}
