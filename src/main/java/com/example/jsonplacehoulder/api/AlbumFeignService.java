package com.example.jsonplacehoulder.api;

import com.example.jsonplacehoulder.api.entities.Album;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "AlbumFeignService",
        url = "https://jsonplaceholder.typicode.com"
)
public interface AlbumFeignService {

    @GetMapping("/albums")
    public List<Album> findAllAlbums();
    @GetMapping("/albums/{id}")
    public Album findAlbumById(@PathVariable Integer id);
}
