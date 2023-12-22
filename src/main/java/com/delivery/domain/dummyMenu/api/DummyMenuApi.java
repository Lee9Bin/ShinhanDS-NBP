package com.delivery.domain.dummyMenu.api;

import com.delivery.domain.dummyMenu.dto.DummyMenuDto;
import com.delivery.domain.dummyMenu.service.DummyMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DummyMenuApi {

    private final DummyMenuService dummyMenuService;

    @Autowired
    public DummyMenuApi(DummyMenuService dummyMenuService) {
        this.dummyMenuService = dummyMenuService;
    }

    @PostMapping("/store/{storeId}/create")
    public ResponseEntity<Void> create(@RequestBody List<DummyMenuDto> dummyMenuDtoList, @PathVariable Long storeId) {
        dummyMenuService.save(dummyMenuDtoList, storeId);
        return ResponseEntity.status(HttpStatus.CREATED).build(); // 201 성공!!
    }
}
