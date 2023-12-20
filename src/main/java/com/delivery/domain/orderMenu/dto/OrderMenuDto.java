package com.delivery.domain.orderMenu.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderMenuDto {

    private Long id;

    @Column(nullable = false)
    private int payment;

    @Column(nullable = false)
    private int totalQuantity;
}
