package com.delivery.domain.dummyMenu.dto;

import com.delivery.domain.dummyMenu.entity.DummyMenu;
import com.delivery.domain.dummyStore.entity.DummyStoreEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DummyMenuDto {
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

    private String picturePath;

    public static DummyMenuDto toDummyMenuDto(DummyMenu dummyMenu, DummyStoreEntity dummyStoreEntity){
        Long storeId = (dummyStoreEntity != null) ? dummyStoreEntity.getId() : null;

        return new DummyMenuDto(
                dummyMenu.getId(),
                dummyMenu.getName(),
                storeId,
                dummyMenu.getPrice(),
                dummyMenu.getContent(),
                dummyMenu.getCategory(),
                dummyMenu.getPicturePath()
        );
    }

    // dto -> entity로 바꾸기
    public DummyMenu toEntity(DummyStoreEntity dummyStoreEntity) {
        return new DummyMenu(
                this.id,
                dummyStoreEntity,
                this.name,
                this.price,
                this.content,
                this.category,
                this.picturePath
        );
    }
}
