package com.delivery.domain.orderDelivery.entiy;


import com.delivery.domain.orderDelivery.dto.OrderDeliveryDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "order_delivery")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDelivery {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_delivery_id")
    private Long id;

    //회원 아이디

    //식당 아이디///

    //배달
    @Column(nullable = false, length = 20)
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @CreatedDate
    private LocalDateTime requestTime;

    @Column(nullable = false, length = 50)
    private String address;

    @Column
    private String requestContent;

    @Column(nullable = false)
    private LocalDateTime deliveryTime;

    @Column(nullable = false)
    private Long payment;

    @Column(nullable = false)
    private Long totalQuantity;

    //배달 예상 시간
    public void createDeliveryTime(Long minute){
        deliveryTime = requestTime.plusMinutes(minute);
    }

    public static OrderDelivery toEntity(OrderDeliveryDto orderDeliveryDto){
        return new OrderDelivery(
                orderDeliveryDto.getId(),
                orderDeliveryDto.getStatus(),
                orderDeliveryDto.getRequestTime(),
                orderDeliveryDto.getAddress(),
                orderDeliveryDto.getRequestContent(),
                orderDeliveryDto.getDeliveryTime(),
                orderDeliveryDto.getPayment(),
                orderDeliveryDto.getTotalQuantity()
        );
    }
}
