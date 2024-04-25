package com.example.jsonplacehoulder.api;

import com.example.jsonplacehoulder.api.entities.Comment;
import com.example.jsonplacehoulder.api.entities.Photo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "PhotoFeignService",
        url = "https://jsonplaceholder.typicode.com"
)
public interface PhotoFeignService {

    @GetMapping("/photos")
    public List<Photo> findAllPhotos();
    @GetMapping("/photos/{id}")
    public Photo findPhotoById(@PathVariable Integer id);
}
