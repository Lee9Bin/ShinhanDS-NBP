package com.delivery.domain.dummyStore.controller;

import com.delivery.domain.dummyStore.entity.DummyStoreEntity;
import com.delivery.domain.dummyStore.service.DummyStoreService;
import groovy.util.logging.Slf4j;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class DummyStoreController {
    private final DummyStoreService dummyStoreService;

    @GetMapping("/searchResults")
    public String searchResultsPage(@RequestParam String searchTerm, Model model) {
        List<DummyStoreEntity> searchResults = dummyStoreService.searchStoresByName(searchTerm);
        model.addAttribute("searchResults", searchResults);

        return "/html/store/StoreFindResult"; // 검색 결과를 보여줄 HTML 파일명
    }

    // 점주 가게 등록 폼
    @GetMapping("/owner/store/new")
    public String storeSaveForm(HttpSession session, Model model) {
        Long ownerId = (Long) session.getAttribute("ownerId");
        model.addAttribute("ownerId",ownerId);
        return "/layouts/owner/regist";
    }

    //MultipartFile은 파일 업로드를 처리하기 위한 객체로, 일반적인 폼 필드와는 다르게 별도로 처리해야 합니다.  ? ?? ?
//    @PostMapping("/owner/store/new")
//    public String storeSave(@Valid @ModelAttribute DummyStore dummyStore,
//                            @RequestParam("file") MultipartFile file,
//                            HttpSession session,
//                            BindingResult result) {
//
//        String ownerId = session.getAttribute("ownerId").toString();
//
//        String ownerName = (String) session.getAttribute("loginName");
//
//        if (!file.isEmpty()) {
//            // 파일이 비어있지 않은 경우에만 처리
//            try {
//                // 파일 저장 로직 추가
//                // 예시: 파일을 서버의 특정 경로에 저장
//                String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename(); // 이름중복방지
//                String filePath = "/static/file/" + fileName;
//                System.out.println("Filepath : " + filePath);
//                File dest = new File(filePath); //transferTo 메서드를 사용하여 파일을 서버에 저장
//
//
//                // 디렉터리 생성 로직 추가
//                File directory = new File(dest.getParent());
//                if (!directory.exists()) {
//                    directory.mkdirs();  // 디렉터리 생성
//                }
//
//
//                file.transferTo(dest);
//
//
//                DummyStore storeDto = new DummyStore();
//                storeDto.setName(storeDto.getName());
//                storeDto.setDescription(storeDto.getDescription());
//                storeDto.setCategory(storeDto.getCategory());
//                storeDto.setRating(storeDto.getRating());
//                storeDto.setFile(fileName);
//
//                dummyStoreService.saveStore(storeDto, Long.valueOf(ownerId));
//            } catch (IOException e) {
//                e.printStackTrace();
//                // 파일 저장 중 예외 발생 시 예외 처리 로직 추가
//            }
//        } else {
//            // 파일이 비어있을 경우에 대한 처리
//        }
//
//        if (result.hasErrors()) {
//            return "error-page";
//        }
//        return "/layouts/owner/regist";
//    }


}

