package com.delivery.domain.dummyStore.dto;

import com.delivery.domain.dummyStore.entity.DummyStoreEntity;
import com.delivery.domain.owner.entity.OwnerEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DummyStore {
    private Long id;

    @JsonProperty("owner_id")
    private Long ownerId;

    private String name;
    private String description;
    private String category;
    private int rating;
    private String file;




    public DummyStoreEntity toEntity(OwnerEntity ownerEntity) {
        return new DummyStoreEntity(
                this.id,
                ownerEntity,
                this.name,
                this.description,
                this.category,
                this.rating,
                this.file
        );
    }

    public static DummyStore toDummyStore(DummyStoreEntity dummyStoreEntity, OwnerEntity ownerEntity) {
        return new DummyStore(
                dummyStoreEntity.getId(),
                ownerEntity.getId(),
                dummyStoreEntity.getName(),
                dummyStoreEntity.getDescription(),
                dummyStoreEntity.getCategory(),
                dummyStoreEntity.getRating(),
                dummyStoreEntity.getFile()
        );
    }
}
