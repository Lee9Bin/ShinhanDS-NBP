package com.delivery.domain.dummyStore.entity;

import com.delivery.domain.dummyStore.dto.DummyStore;
import com.delivery.domain.owner.entity.OwnerEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter
public class DummyStoreEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "owner_id")
        private OwnerEntity ownerEntity;

        private String name;
        private String description;
        private String category;
        private int rating;
        private String file;
        // 페이지 크기를 나타내는 정적상수
        public static final int PAGE_SIZE = 8;
        // 가게사진


        public DummyStoreEntity(Long id, OwnerEntity ownerEntity, String name, String description, String category, int rating, String file) {
                this.id = id;
                this.ownerEntity = ownerEntity;
                this.name = name;
                this.description = description;
                this.category = category;
                this.rating = rating;
                this.file = file;
        }

        // toDummyStoreEntity 메소드 수정
        public static DummyStoreEntity toDummyStoreEntity(DummyStore dummyStore, OwnerEntity ownerEntity) {
                return new DummyStoreEntity(
                        dummyStore.getId(),
                        ownerEntity,
                        dummyStore.getName(),
                        dummyStore.getDescription(),
                        dummyStore.getCategory(),
                        dummyStore.getRating(),
                        dummyStore.getFile()
                );
        }


}


