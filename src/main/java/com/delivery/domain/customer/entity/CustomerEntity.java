package com.delivery.domain.customer.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    private String password;

    @Column
    @NotNull
    private String phone;

    @Column
    @NotNull
    private String nickname;

    @Column
    @NotNull
    private String adress;

    @Column
    @NotNull
    private String point;
}
