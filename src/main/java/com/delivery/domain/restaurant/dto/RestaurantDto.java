package com.delivery.domain.restaurant.dto;

import com.delivery.domain.restaurant.entiy.Restaurant;
import lombok.*;

@Getter
@Setter //안쓰면 폼객체에서 입력이 안돼
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {
    private Long id;
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


    public static RestaurantDto toDto(Restaurant restaurant){
        return new RestaurantDto(restaurant.getId(),
                restaurant.getName(),
                restaurant.getPhone(),
                restaurant.getAddress(),
                restaurant.getCloseDay(),
                restaurant.getOpenTime(),
                restaurant.getCloseTime(),
                restaurant.getContent(),
                restaurant.getPicture(),
                restaurant.getCategory(),
                restaurant.getStoreRegister());
    }
}
