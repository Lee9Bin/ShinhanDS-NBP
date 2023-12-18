package com.delivery.domain.menu.entity;

import com.delivery.domain.restaurant.entity.Restaurant;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Menu")
@Table(name = "menu")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id")
    private Restaurant restaurant;

    @NotNull
    private String photo;
    @NotNull
    private String name;
    @NotNull
    private int price;
    @NotNull
    private String content;
    @NotNull
    private String category;
    @NotNull
    private int popular;


    @NotNull
    private String menu;
    @Override
    public String toString() {
        return menu;
    }
}
