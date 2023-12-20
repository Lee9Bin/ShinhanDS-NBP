package com.delivery.domain.menu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Table(name = "menu")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class MenuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private int price;

    @NotNull
    @Column
    private String content;

    @NotNull
    @Column
    private String popular;

    @NotNull
    @Column
    private String photo;

    public void patch(MenuEntity menuEntity){
        if(menuEntity.price !=null){
            this.price = menuEntity.price;
        }
        if(menuEntity.content !=null){
            this.content = menuEntity.content;
        }
    }
}


