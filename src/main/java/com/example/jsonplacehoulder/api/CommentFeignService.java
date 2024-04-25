package com.example.jsonplacehoulder.api;

import com.example.jsonplacehoulder.api.entities.Album;
import com.example.jsonplacehoulder.api.entities.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient(
        name = "CommentsFeignService",
        url = "https://jsonplaceholder.typicode.com"
)
public interface CommentFeignService {

    @GetMapping("/comments")
    public List<Comment> findAllComments(@RequestParam(required = false) Integer postId);
    @GetMapping("/comments/{id}")
    public Comment findCommentById(@PathVariable Integer id);
}
