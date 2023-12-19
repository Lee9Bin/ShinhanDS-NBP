package com.delivery.domain.orderDelivery.service;

import com.delivery.domain.orderDelivery.dto.OrderDeliveryDto;
import com.delivery.domain.orderDelivery.entiy.OrderDelivery;
import com.delivery.domain.orderDelivery.entiy.Status;
import com.delivery.domain.orderDelivery.repositry.OrderDeliveryRepository;
import com.delivery.domain.restaurant.dto.RestaurantDto;
import com.delivery.domain.restaurant.entiy.Restaurant;
import com.delivery.domain.restaurant.repositry.RestaurantRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderDeliveryService {

    private final OrderDeliveryRepository orderDeliveryRepository;


    //등록하는 거니깐 기본 트랜잭션 걸어주기
    //주문하기
    @Transactional
    public Long save(@Valid OrderDeliveryDto orderDeliveryDto){
        // 처음 주믄을 하면 요청수락대기 단계
        orderDeliveryDto.setStatus(Status.WAIT);
        orderDeliveryDto.setRequestTime(LocalDateTime.now());
        OrderDelivery orderDelivery = OrderDelivery.toEntity(orderDeliveryDto);
        orderDelivery.createDeliveryTime(10L);
        OrderDelivery saveId = orderDeliveryRepository.save(orderDelivery);
        return saveId.getId();
    }
}
