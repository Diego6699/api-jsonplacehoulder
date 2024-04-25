package com.example.jsonplacehoulder.api;

import com.example.jsonplacehoulder.api.entities.Comment;
import com.example.jsonplacehoulder.api.entities.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "PostsClient",
        url = "https://jsonplaceholder.typicode.com"
)
public interface PostFeignService {
    @GetMapping("/posts")
    public List<Post> findAll(@RequestParam(required = false) Integer userId,@RequestParam(required = false) Integer id);

    @GetMapping("/posts/{id}")
    public Post findById(@PathVariable("id") Integer id);

    @GetMapping("/posts/{id}/comments")
    public List<Comment> findAllCommentsByPostId(@PathVariable("id") Integer id);

    @PostMapping("/posts")
    public Post insertNewPost(@RequestBody Post post);

    @PutMapping("/posts/{id}")
    public Post updatePost(@RequestBody Post post, @PathVariable("id") Integer id);

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable("id") Integer id);

}
