package com.delivery.domain.orderMenu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_menu")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_menu_id")
    private Long id;


    @Column(nullable = false)
    private String menuName; // 메뉴 이름

    @Column(nullable = false)
    private int payment; // 메뉴 가격

    @Column(nullable = false)
    private int quantity; //수량

    @Column(nullable = false)
    private int totalAmount; // 최종 가격


}