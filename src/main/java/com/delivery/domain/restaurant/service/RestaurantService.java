package com.delivery.domain.restaurant.service;

import com.delivery.domain.restaurant.dto.RestaurantDto;
import com.delivery.domain.restaurant.entiy.Restaurant;
import com.delivery.domain.restaurant.repositry.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;


    //등록하는 거니깐 기본 트랜잭션 걸어주기
    //등록
    @Transactional
    public Long save(RestaurantDto restaurantCreateDto){
        Restaurant restaurant = Restaurant.toEntity(restaurantCreateDto);
        restaurantRepository.save(restaurant);
        return restaurant.getId();
    }

    //아이디를 받아서 조회
    public RestaurantDto findById(Long targetId){
        //해당
        Optional<Restaurant> target = restaurantRepository.findById(targetId);

        if (target.isPresent()){
            return RestaurantDto.toDto(target.get());
        }
        else{
            return null;
        }
    }

    //업데이트
    @Transactional
    public RestaurantDto update(RestaurantDto restaurantDto){
        Restaurant target = Restaurant.toEntity(restaurantDto);
        Optional<Restaurant> findTarget = restaurantRepository.findById(target.getId());

        if (findTarget.isPresent()){
            restaurantRepository.save(target);
            return RestaurantDto.toDto(target);
        }
        else{
            return null;
        }
    }

    //삭제
    @Transactional
    public String delete(Long id){
        Optional<Restaurant> target = restaurantRepository.findById(id);

        if (target.isPresent()){
            restaurantRepository.delete(target.get());
            return "가게 정보를 삭제합니다";
        }
        else{
            return "가게 정보를 삭제하지 못했습니다";
        }
    }
}
