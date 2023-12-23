package com.delivery.controller;

import com.delivery.domain.dummyStore.entity.DummyStoreEntity;
import com.delivery.domain.dummyStore.repository.DummyStoreRepository;
import com.delivery.domain.owner.dto.OwnerDTO;
import com.delivery.domain.owner.service.OwnerService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RequestMapping("/owner")
@Controller
@RequiredArgsConstructor
@Slf4j
public class KkyOwnerController {

    private final DummyStoreRepository dummyStoreRepository;
    private final OwnerService ownerService;

    @GetMapping(value = "/{ownerId}")
//    @PathVariable Long articleId
    public String ownerHome(Model model, @PathVariable Long ownerId, HttpSession session){
        OwnerDTO ownerDTO = ownerService.findById(ownerId);
        // owner의 값 불러옴 3번 - 채원이
        log.info("bb - " + ownerDTO.toString());
        Optional<DummyStoreEntity> dummyStoreEntity = dummyStoreRepository.findByOwnerEntity_Id(ownerId);
        log.info("aa - " + dummyStoreEntity.toString());
        model.addAttribute("owner", ownerDTO);  // 모델에 회원 정보를 담아서 전달
        dummyStoreEntity.ifPresent(store -> model.addAttribute("ownerStore", store));

        // 아이디에 해당하는 회원 정보 조회 (한명 걍 dto)
        session.setAttribute("loginName", ownerDTO.getOwnerName());


        // dummyStoreEntity가 null이 아니고 존재하면 모델에 추가
//        dummyStoreEntity.ifPresent(entity -> model.addAttribute("stores", Collections.singletonList(entity)));
        return "layouts/owner/ownerNewMain";

    }




}
