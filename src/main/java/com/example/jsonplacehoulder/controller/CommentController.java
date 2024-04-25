package com.example.jsonplacehoulder.controller;

import com.example.jsonplacehoulder.api.AlbumFeignService;
import com.example.jsonplacehoulder.api.CommentFeignService;
import com.example.jsonplacehoulder.api.entities.Album;
import com.example.jsonplacehoulder.api.entities.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/")
public class CommentController {

    @Autowired
    private CommentFeignService commentFeignService;
    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> findAllAlbums(@RequestParam(required = false) Integer postId){
        return ResponseEntity.ok(commentFeignService.findAllComments(postId));
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<Comment> findAlbumById(@PathVariable Integer id){
        return ResponseEntity.ok(commentFeignService.findCommentById(id));
    }
}
