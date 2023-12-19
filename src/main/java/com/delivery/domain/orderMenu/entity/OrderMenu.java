package com.delivery.domain.orderMenu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_menu")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_menu_id")
    private Long id;

    //주문 아이디

    //메뉴 아이디///

    @Column(nullable = false)
    private Long payment;

    @Column(nullable = false)
    private Long totalQuantity;

}
