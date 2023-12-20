package com.delivery.domain.menu.controller;


import com.delivery.domain.menu.dto.MenuDto;

import com.delivery.domain.menu.entity.MenuEntity;
import com.delivery.domain.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/menu")
@Slf4j
@RequiredArgsConstructor
public class MenuController {


    private final MenuRepository menuRepository;

    @GetMapping("/new")
    public String newArticleForm(){return "html/menu/MenuAdd";}

    @PostMapping("/create")
    public String create(@ModelAttribute MenuDto form){

        MenuEntity menu = form.toEntity();
        log.info(menu.toString());

        MenuEntity saved = menuRepository.save(menu);

        log.info(saved.toString());
        return "redirect:/menu/" + saved.getId();
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id= " + id);

        Optional<MenuEntity> menuEntity = menuRepository.findById(id);

        if(menuEntity.isPresent()){
            model.addAttribute("menu", menuEntity.get());
        }
        return "html/menu/MenuShow";
    }

    //목록보기
    @GetMapping("")
    public String list(Model model){

        List<MenuEntity> menuEntityList = menuRepository.findAll();
        log.info(menuEntityList.toString());

        model.addAttribute("menuList", menuEntityList);
        return "html/menu/MenuList";
    }

    //수정하기
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model){

        Optional<MenuEntity> menuEntity = menuRepository.findById(id);

        if(menuEntity.isPresent()){
            model.addAttribute("menu", menuEntity.get());
        }
        return "html/menu/MenuEdit";
    }

    @PostMapping ("/{id}/put")
    public String editPut(@ModelAttribute MenuDto form){

        MenuEntity menu = form.toEntity();
        log.info(form.toString());

        Optional<MenuEntity> target = menuRepository.findById(menu.getId());

        if(target.isPresent()){
            menuRepository.save(menu);
        }
        return "redirect:/menu/" +menu.getId();
    }

    @GetMapping ("/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr){
        log.info("삭제요청");

        Optional<MenuEntity> target = menuRepository.findById(id);

        if(target.isPresent()){
            menuRepository.delete(target.get());
            rttr.addFlashAttribute("msg", "게시물삭제");
        }
        return "redirect:/menu";
    }

}
