package com.delivery.domain.dummyMenu.service;

import static org.junit.jupiter.api.Assertions.*;

import com.delivery.domain.dummyMenu.dto.DummyMenuDto;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
class DummyMenuServiceTest {
    @Autowired
    private DummyMenuService dummyMenuService;



    @Test
    @Rollback(value = false)
    void 메뉴저장(){
        List<DummyMenuDto> dummyMenuDtoList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            DummyMenuDto dummyMenuDto = new DummyMenuDto();
            dummyMenuDto.setName("짜장면"+i);
            dummyMenuDto.setPrice(i*1000);
            dummyMenuDto.setContent("쩐나게 맛있어요~"+i);
            dummyMenuDtoList.add(dummyMenuDto);
        }

        dummyMenuService.save(dummyMenuDtoList, 1L);
    }
}