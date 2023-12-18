//package com.delivery.domain.comment.api;
//
//import com.delivery.domain.comment.entity.CommentEntity;
//import com.delivery.domain.comment.service.CommentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class CommentApiController {
//    @Autowired
//    CommentService commentService;
//
//    // 댓글 목록 조회
//    @GetMapping("/articles/{id}/comments")
//    public List<CommentEntity> comments(@PathVariable Long id){
//        // 서비스에게 위임
//
//        // 결과물 응답
////        return (created != null) ?
////                ResponseEntity.status(HttpStatus.OK).body(created) :
////                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//    }
//    // 댓글 생성
//
//    // 댓글 수정
//
//    // 댓글 삭제
//}
