package com.delivery.domain.orderDelivery.service;

import com.delivery.domain.orderDelivery.dto.OrderDeliveryDto;
import com.delivery.domain.orderDelivery.entiy.OrderDelivery;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
class OrderDeliveryServiceTest {
    @Autowired
    private OrderDeliveryService orderDeliveryService;
    @Test
    @Rollback(value = false)
    void 배달주문(){
        //given
        OrderDeliveryDto orderDeliveryDto = new OrderDeliveryDto();
        orderDeliveryDto.setAddress("");
        orderDeliveryDto.setRequestContent("맛있게 부탁드려요~");
        orderDeliveryDto.setPayment(10000L);
        orderDeliveryDto.setTotalQuantity(10L);
        //when
        Long save = orderDeliveryService.save(orderDeliveryDto);
        //then
        Assertions.assertThat(save).isEqualTo(4);
    }

}