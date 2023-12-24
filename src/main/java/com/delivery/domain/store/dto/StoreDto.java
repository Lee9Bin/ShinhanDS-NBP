package com.delivery.domain.store.dto;

import com.delivery.domain.store.entity.StoreEntity;
import com.delivery.domain.owner.entity.OwnerEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StoreDto {
    private Long id;
    private Long ownerId;
    private String name;
    private String description;
    private String category;
    private int rating;
    private String file;


    public static StoreDto toDummyStore(StoreEntity storeEntity, OwnerEntity ownerEntity){
        return new StoreDto(
                storeEntity.getId(),
                ownerEntity.getId(),
                storeEntity.getName(),
                storeEntity.getDescription(),
                storeEntity.getCategory(),
                storeEntity.getRating(),
                storeEntity.getFile()
        );
    }
}
