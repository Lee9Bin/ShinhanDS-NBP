package com.delivery.domain.store.controller;

import com.delivery.domain.store.dto.StoreDto;
import com.delivery.domain.store.entity.StoreEntity;
import com.delivery.domain.store.service.StoreService;
import groovy.util.logging.Slf4j;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.hibernate.query.sqm.tree.SqmNode.log;

@Controller
@Slf4j
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    //키워드 검색
    @GetMapping("/searchResults")
    public String searchResultsPage(@RequestParam String searchTerm, Model model) {
        List<StoreEntity> searchResults = storeService.searchStoresByName(searchTerm);
        model.addAttribute("searchResults", searchResults);

        return "/html/store/StoreFindResult"; // 검색 결과를 보여줄 HTML 파일명
    }

    // 점주 가게 등록 폼
    @GetMapping("/owner/store/new")

    public String storeSaveForm(HttpSession session, Model model) {
        Long ownerId = (Long) session.getAttribute("ownerId");
        model.addAttribute("ownerId",ownerId);
        model.addAttribute("storeDto", new StoreDto());
        return "/layouts/owner/regist";

    }

    //점주 가게 등록 저장
    @PostMapping("/owner/store/new")
    public String storeSave(@ModelAttribute StoreDto storeDto, HttpSession session){
        storeService.save(storeDto, (Long) session.getAttribute("ownerId"));
        return "redirect:/owner/" + session.getAttribute("ownerId");
    }

    //점주 수정 폼
    @GetMapping("/owner/store/update")
    public String storeUpdateForm(Model model, HttpSession session) {
        StoreDto storeDto = storeService.findById((Long) session.getAttribute("ownerId"));

        model.addAttribute("storeDto",storeDto);
        return "layouts/html/update";
    }

    //점주 수정
    @PostMapping("/owner/store/update")
    public String storeUpdateForm(@ModelAttribute StoreDto storeDto, HttpSession session) {
        log.info("수정폼에서 넘어온 폼 객체입니다."+storeDto);
        storeService.update(storeDto,(Long) session.getAttribute("ownerId"));
        return "redirect:/owner/store/update";
    }



    // //MultipartFile은 파일 업로드를 처리하기 위한 객체로, 일반적인 폼 필드와는 다르게 별도로 처리해야 합니다.  ? ?? ?
    // @PostMapping("/owner/store/new")
    // public String storeSave(@RequestParam String name,
    //                         @RequestParam String description,
    //                         @RequestParam String category,
    //                         @RequestParam int rating,
    //                         @RequestParam("file") MultipartFile file,
    //                         HttpSession session) {
    //
    //     String ownerId = session.getAttribute("ownerId").toString();
    //
    //     String ownerName = (String) session.getAttribute("loginName");
    //
    //     if (!file.isEmpty()) {
    //         // 파일이 비어있지 않은 경우에만 처리
    //         try {
    //             // 파일 저장 로직 추가
    //             // 예시: 파일을 서버의 특정 경로에 저장
    //             String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename(); // 이름중복방지
    //             String filePath = "/static/file/" + fileName;
    //             System.out.println("Filepath : " + filePath);
    //             File dest = new File(filePath); //transferTo 메서드를 사용하여 파일을 서버에 저장
    //
    //
    //             // 디렉터리 생성 로직 추가
    //             File directory = new File(dest.getParent());
    //             if (!directory.exists()) {
    //                 directory.mkdirs();  // 디렉터리 생성
    //             }
    //
    //
    //             file.transferTo(dest);
    //
    //
    //             StoreDto storeDto = new StoreDto();
    //             storeDto.setName(name);
    //             storeDto.setDescription(description);
    //             storeDto.setCategory(category);
    //             storeDto.setRating(rating);
    //             storeDto.setFile(fileName);
    //
    //             storeService.saveStore(storeDto, Long.valueOf(ownerId));
    //         } catch (IOException e) {
    //             e.printStackTrace();
    //             // 파일 저장 중 예외 발생 시 예외 처리 로직 추가
    //         }
    //     } else {
    //         // 파일이 비어있을 경우에 대한 처리
    //     }
    //
    //     return "/layouts/owner/regist";
    // }


}

