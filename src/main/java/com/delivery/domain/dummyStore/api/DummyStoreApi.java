package com.delivery.domain.dummyStore.api;

import com.delivery.domain.dummyStore.dto.DummyStore;
import com.delivery.domain.dummyStore.entity.DummyStoreEntity;
import com.delivery.domain.dummyStore.repository.DummyStoreRepository;
import com.delivery.domain.dummyStore.service.DummyStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class DummyStoreApi {

    private final DummyStoreRepository dummyStoreRepository;
    private final DummyStoreService dummyStoreService;
    @Autowired
    public DummyStoreApi(DummyStoreRepository dummyStoreRepository,DummyStoreService dummyStoreService) {
        this.dummyStoreRepository = dummyStoreRepository;
        this.dummyStoreService = dummyStoreService;
    }

    @GetMapping("/get-more-data")
    public ResponseEntity<List<DummyStoreEntity>> getMoreData(@RequestParam(name = "page", defaultValue = "0") int page,
                                                              @RequestParam(name = "pageSize", defaultValue = "8") int pageSize) {
        // 페이징 처리를 위한 Pageable 객체 생성
        Pageable pageable = PageRequest.of(page, pageSize);
        log.info(pageable.toString());

        // 해당 페이지의 데이터를 가져옴
        Page<DummyStoreEntity> dummyStorePage = dummyStoreRepository.findAll(pageable);
        log.info("aaa: " + dummyStorePage.toString());
        List<DummyStoreEntity> newData = dummyStorePage.getContent();
        log.info("bbbb: " + newData.toString());

        // ResponseEntity를 사용하여 클라이언트에 응답 데이터 전송
        return ResponseEntity.ok().body(newData);
    }

    @PostMapping("/new/store/{ownerId}/create")
    public ResponseEntity<DummyStore> create(@PathVariable Long ownerId, @RequestBody DummyStore dummyStore) {

        log.info("ownerId = {}", ownerId);

        log.info("dummyStore = {}", dummyStore);

        dummyStoreService.save(dummyStore, ownerId);
        return ResponseEntity.status(HttpStatus.CREATED).build(); // 201 성공!!
    }
}
