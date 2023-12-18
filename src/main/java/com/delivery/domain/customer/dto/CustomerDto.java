package com.delivery.domain.customer.dto;

import com.delivery.domain.article.entity.ArticleEntity;
import com.delivery.domain.customer.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class CustomerDto {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String nickname;
    private String adress;
    private String point;

    public CustomerEntity toEntity(){
        return new CustomerEntity(id, name, email, password, phone, nickname, adress, point );
    }
}
