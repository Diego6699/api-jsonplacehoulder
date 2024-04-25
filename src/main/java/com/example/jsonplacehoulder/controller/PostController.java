package com.example.jsonplacehoulder.controller;

import com.example.jsonplacehoulder.api.PostFeignService;
import com.example.jsonplacehoulder.api.entities.Comment;
import com.example.jsonplacehoulder.api.entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/")
public class PostController {
    @Autowired
    private PostFeignService postFeignService;
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> findAllPosts(@RequestParam(required = false) Integer userId, @RequestParam(required = false) Integer id){
        return ResponseEntity.ok(postFeignService.findAll(userId,id));
    }
    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> findById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(postFeignService.findById(id));
    }
    @GetMapping("/posts/{id}/comments")
    public ResponseEntity<List<Comment>> findAllCommentsByPostId(@PathVariable("id") Integer id){
        return ResponseEntity.ok(postFeignService.findAllCommentsByPostId(id));
    }
    @PostMapping("/posts")
    public ResponseEntity<Post> insertNewPost(@RequestBody Post post){
        Post postResponse = postFeignService.insertNewPost(post);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(postResponse.getId()).toUri();
        return ResponseEntity.created(uri).body(postResponse);
    }
    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@RequestBody Post post,@PathVariable("id") Integer id){
        post = postFeignService.updatePost(post,id);
        return ResponseEntity.ok(post);
    }
    @DeleteMapping("/posts")
    public ResponseEntity<Void> deletePost(@PathVariable("id") Integer id){
        return ResponseEntity.noContent().build();
    }
}
