package com.delivery.domain.store.dto;

import com.delivery.domain.store.entity.StoreEntity;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.sql.Time;
import java.sql.Date;

@AllArgsConstructor
@ToString
public class StoreDto {

    private String title;
    private String tel;
    private Time opentime;
    private Time endtime;
    private Date restdate;
    private String addr;
    private String content;

    public StoreEntity toEntity(){
        return new StoreEntity(title, tel, opentime, endtime, restdate, addr, content);
    }
}
