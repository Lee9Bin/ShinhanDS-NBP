package com.delivery.domain.store.entity;

import com.delivery.domain.store.dto.StoreDto;
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
@AllArgsConstructor
@Table(name = "store")
public class StoreEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        //점주테이블 조인
        @OneToOne(fetch = FetchType.LAZY)
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

        public static StoreEntity toStoreEntity(StoreDto storeDto, OwnerEntity ownerEntity) {
                return new StoreEntity(
                        storeDto.getId(),
                        ownerEntity,
                        storeDto.getName(),
                        storeDto.getDescription(),
                        storeDto.getCategory(),
                        storeDto.getRating(),
                        storeDto.getFile()
                );
        }
}


