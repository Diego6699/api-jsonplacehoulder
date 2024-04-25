package com.example.jsonplacehoulder.controller;

import com.example.jsonplacehoulder.api.AlbumFeignService;
import com.example.jsonplacehoulder.api.entities.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/")
public class AlbumController {
    @Autowired
    private AlbumFeignService albumFeignService;
    @GetMapping("/albums")
    public ResponseEntity<List<Album>> findAllAlbums(){
        return ResponseEntity.ok(albumFeignService.findAllAlbums());
    }

    @GetMapping("/albums/{id}")
    public ResponseEntity<Album> findAlbumById(@PathVariable Integer id){
        return ResponseEntity.ok(albumFeignService.findAlbumById(id));
    }
}
