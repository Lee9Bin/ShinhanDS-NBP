package com.delivery.domain.dummyMenu.entity;

import com.delivery.domain.dummyMenu.dto.DummyMenuDto;
import com.delivery.domain.dummyStore.entity.DummyStoreEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class DummyMenu {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dummy_menu_id")
    private Long id;

    //식당 아이디
    @ManyToOne
    @JoinColumn(name = "dummy_store_id")
    private DummyStoreEntity dummyStoreEntity;

    private String name;

    private int price;

    private String content;

    private String category;

    private String picturePath;
    //== 엔티티 변환 메서드 ==//
    public static DummyMenu toEntity(DummyMenuDto dummyMenuDto, DummyStoreEntity dummyStoreEntity){
        return new DummyMenu(
                dummyMenuDto.getId(),
                dummyStoreEntity,
                dummyMenuDto.getName(),
                dummyMenuDto.getPrice(),
                dummyMenuDto.getContent(),
                dummyMenuDto.getCategory(),
                dummyMenuDto.getPicturePath()
        );
    }
}
