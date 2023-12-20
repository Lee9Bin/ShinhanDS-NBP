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
    private Status status = Status.WAIT;
    private LocalDateTime requestTime = LocalDateTime.now();

    @NotBlank(message = "주소는 빈값일 수 없다.")
    private String address;
    private String requestContent;
    private LocalDateTime deliveryTime = requestTime.plusMinutes(30);

<<<<<<< HEAD
//    public static OrderDeliveryDto toDto(OrderDelivery orderDelivery){
//        return new OrderDeliveryDto(
//                orderDelivery.getId(),
//                orderDelivery.getStatus(),
//                orderDelivery.getRequestTime(),
//                orderDelivery.getAddress(),
//                orderDelivery.getRequestContent(),
//                orderDelivery.getDeliveryTime(),
//                orderDelivery.getPayment(),
//                orderDelivery.getTotalQuantity()
//        );
//    }
=======
    public static OrderDeliveryDto toDto(OrderDelivery orderDelivery){
        return new OrderDeliveryDto(
                orderDelivery.getId(),
                orderDelivery.getStatus(),
                orderDelivery.getRequestTime(),
                orderDelivery.getAddress(),
                orderDelivery.getRequestContent(),
                orderDelivery.getDeliveryTime()
        );
    }
>>>>>>> 075293dbe90009d932c5cebec99d1516d1eac9e8
}
