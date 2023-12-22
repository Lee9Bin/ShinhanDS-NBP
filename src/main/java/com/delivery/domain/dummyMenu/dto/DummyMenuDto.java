package com.delivery.domain.dummyMenu.dto;

import com.delivery.domain.dummyMenu.entity.DummyMenu;
import com.delivery.domain.dummyStore.entity.DummyStoreEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DummyMenuDto {
    private Long id;

    //식당 아이디
//    @ManyToOne
//    @JoinColumn(name = "dummy_store_id")
//    private DummyStoreEntity dummyStoreEntity;

    private String name;

    private Long storeId;

    private int price;

    private String content;

    private String category;

    private String picturePath;

    public static DummyMenuDto toDummyMenuDto(DummyMenu dummyMenu, DummyStoreEntity dummyStoreEntity){
        return new DummyMenuDto(
                dummyMenu.getId(),
                dummyMenu.getName(),
                dummyStoreEntity.getId(),
                dummyMenu.getPrice(),
                dummyMenu.getContent(),
                dummyMenu.getCategory(),
                dummyMenu.getPicturePath()
        );
    }
}
