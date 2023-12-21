//package com.delivery.domain.store.service;
//
//
//import com.delivery.domain.store.entity.StoreEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class StoreService {
//    private static List<StoreEntity> dummyStores = generateDummyStores();
//
//    public List<StoreEntity> getInitialStores() {
//        return dummyStores.subList(0, 8);
//    }
//
//    public List<StoreEntity> getAdditionalStores() {
//        int currentSize = dummyStores.size();
//        int endIndex = Math.min(currentSize + 8, dummyStores.size());
//        return dummyStores.subList(currentSize, endIndex);
//    }
//
//    private static List<StoreEntity> generateDummyStores() {
//        List<StoreEntity> stores = new ArrayList<>();
//        // 여기서 더미 데이터 생성 및 stores 리스트에 추가
//        // 예:
//        stores.add(new StoreEntity("화홍루", "경기 수원시 장안구", "10시", ""));
//        stores.add(new StoreEntity("황금성", "짬뽕이 더 맛있음", 1, 1));
//        stores.add(new StoreEntity("또복이네", "20년 전통 짜장면", 1, 3));
//        stores.add(new StoreEntity("자바네", "간짜장 맛집", 1, 2));
//        stores.add(new StoreEntity("화옹루", "전통 짜장면집", 1, 1));
//        // ... 더 많은 가게 추가
//        return stores;
//    }
//}
