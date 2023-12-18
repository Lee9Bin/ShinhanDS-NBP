package com.delivery.domain.orderDelivery.dto;


import com.delivery.domain.orderDelivery.entiy.OrderDelivery;
import com.delivery.domain.orderDelivery.entiy.Status;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDeliveryDto {

    private Long id;
    private Status status;
    private LocalDateTime requestTime;

    @NotBlank(message = "주소는 빈값일 수 없다.")
    private String address;
    private String requestContent;
    private LocalDateTime deliveryTime;
    private Long payment;
    private Long totalQuantity;

    public static OrderDeliveryDto toDto(OrderDelivery orderDelivery){
        return new OrderDeliveryDto(
                orderDelivery.getId(),
                orderDelivery.getStatus(),
                orderDelivery.getRequestTime(),
                orderDelivery.getAddress(),
                orderDelivery.getRequestContent(),
                orderDelivery.getDeliveryTime(),
                orderDelivery.getPayment(),
                orderDelivery.getTotalQuantity()
        );
    }
}
