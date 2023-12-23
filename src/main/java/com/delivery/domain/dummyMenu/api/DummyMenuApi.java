package com.delivery.domain.dummyMenu.api;

import com.delivery.domain.dummyMenu.dto.DummyMenuDto;
import com.delivery.domain.dummyMenu.service.DummyMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class DummyMenuApi {

    private final DummyMenuService dummyMenuService;

    @Autowired
    public DummyMenuApi(DummyMenuService dummyMenuService) {
        this.dummyMenuService = dummyMenuService;
    }

    @PostMapping("/store/{storeId}/create")
    public ResponseEntity<Void> create(@RequestBody List<DummyMenuDto> dummyMenuDtoList, @PathVariable Long storeId) {
        log.info("dummyMenuDtoList = {}", dummyMenuDtoList);
        for (DummyMenuDto dto : dummyMenuDtoList) {
            log.info("DummyMenuDto - {}", dto);
        }
        log.info("b = " + storeId.toString());
        DummyMenuDto dummyMenuDto = dummyMenuService.save(dummyMenuDtoList, storeId);
        if (dummyMenuDto != null) {
            // 기존 코드
            log.info("dummyMenu - " + dummyMenuDto.toString());
            // ...
        } else {
            // null인 경우 처리
            // 예: 로깅 또는 다른 처리
            log.error("dummyMenuDto is null");
        }

        return ResponseEntity.status(HttpStatus.CREATED).build(); // 201 성공!!
    }
}
