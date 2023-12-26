package com.delivery.domain.menu.dto;

import com.delivery.domain.menu.entity.MenuEntity;
import com.delivery.domain.store.entity.StoreEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MenuDto {
    private Long id;

    //식당 아이디
//    @ManyToOne
//    @JoinColumn(name = "dummy_store_id")
//    private DummyStoreEntity dummyStoreEntity;

    private String name;

    @JsonProperty("dummy_store_id")
    private Long storeId;

    private int price;

    private String content;

    private String category;

    public static MenuDto toMenuDto(MenuEntity dummyMenuEntity, StoreEntity storeEntity){
        Long storeId = (storeEntity != null) ? storeEntity.getId() : null;

        return new MenuDto(
                dummyMenuEntity.getId(),
                dummyMenuEntity.getName(),
                storeId,
                dummyMenuEntity.getPrice(),
                dummyMenuEntity.getContent(),
                dummyMenuEntity.getCategory()
        );
    }

    // dto -> entity로 바꾸기
    public MenuEntity toEntity(StoreEntity storeEntity) {
        return new MenuEntity(
                this.id,
                storeEntity,
                this.name,
                this.price,
                this.content,
                this.category,
                this.picturePath
        );
    }
}
