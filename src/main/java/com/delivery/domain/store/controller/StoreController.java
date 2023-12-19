package com.delivery.domain.store.controller;

import com.delivery.domain.store.dto.StoreDto;
import com.delivery.domain.store.entity.StoreEntity;
import com.delivery.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/owner2")
@Slf4j
@RequiredArgsConstructor
public class StoreController {

    private final StoreRepository ownerRepository;

    //조회페이지
    @GetMapping("/new")
    public String allStore(){
        return "html/owner2/ownerStore";}

    //등록페이지
    @PostMapping("/create")
    public String create(@ModelAttribute StoreDto form){

        StoreEntity owner = form.toEntity();
        StoreEntity saved =ownerRepository.save(owner);

        return "redirect:/owner2/" + saved;
    }

    @GetMapping("")
    public String list(Model model){

        List<StoreEntity> ownerEntityList = ownerRepository.findAll();


        model.addAttribute("ownerList", ownerEntityList);
        return "html/owner2/ownerStoreList";
    }

    //수정페이지
    @GetMapping("/edit/{title}")
    public String editStoreForm(@ModelAttribute String title, Model model){

        Optional<StoreEntity> ownerEntity = ownerRepository.findById(title);

        if(ownerEntity.isPresent()){
            model.addAttribute("owner", ownerEntity.get());
        }

        return "html/owner2/ownerStoreRe";}

    @PostMapping("/edit/{title}/put")
    @NotNull
    public String edit(@ModelAttribute StoreDto form){

        StoreEntity owner = form.toEntity();
        log.info(form.toString());

        Optional<StoreEntity> target = ownerRepository.findById(owner.getTitle());

        if(target.isPresent()){
            ownerRepository.save(owner);
        }

        return "redirect:/owner2/" + owner.getTitle();
    }

}
