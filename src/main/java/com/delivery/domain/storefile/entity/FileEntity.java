//package com.delivery.domain.storefile.entity;
//
//import com.delivery.domain.owner.entity.OwnerEntity;
//import com.delivery.domain.store.entity.StoreEntity;
//import jakarta.persistence.*;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@NoArgsConstructor
//@Table(name = "file")
//@Entity
//@Getter
//@Setter
//public class FileEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="file_id")
//    private Long id;
//
//    @OneToOne
//    @JoinColumn(name = "owner_id")
//    private OwnerEntity ownerEntity;
//
//    @ManyToOne
//    @JoinColumn(name = "store_id")
//    private StoreEntity storeEntity;
//
//    private String orgNm;
//
//    private String savedNm;
//
//    private String savedPath;
//
//    @Builder
//    public FileEntity(Long id, String orgNm, String savedNm, String savedPath) {
//        this.id = id;
//        this.orgNm = orgNm;
//        this.savedNm = savedNm;
//        this.savedPath = savedPath;
//    }
//}
