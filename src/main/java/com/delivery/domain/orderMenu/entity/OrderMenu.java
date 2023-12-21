package com.delivery.domain.orderMenu.entity;

import com.delivery.domain.orderDelivery.entiy.OrderDelivery;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    @JoinColumn(name = "order_delivery_id")
    private OrderDelivery orderDelivery;
    //메뉴 아이디///
    // @ManyToOne
    // @JoinColumn(name = "menu_id")
    // private MenuEntity menuEntity;

    @Column(nullable = false)
    private int payment;

    @Column(nullable = false)
    private int totalQuantity;

    //== 가격 계산==//
    public int calculationPrice(){
        return getPayment() * getTotalQuantity();
    }


    // public static OrderMenu create(OrderDelivery orderDelivery, MenuEntity menuEntity, int count){
    //     return new OrderMenu(
    //             null,
    //             orderDelivery,
    //             menuEntity,
    //             menuEntity.getPrice(),
    //             count
    //     );
    // }


}
