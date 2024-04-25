package com.example.jsonplacehoulder.controller;

import com.example.jsonplacehoulder.api.AlbumFeignService;
import com.example.jsonplacehoulder.api.PhotoFeignService;
import com.example.jsonplacehoulder.api.entities.Album;
import com.example.jsonplacehoulder.api.entities.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class PhotoController {

    @Autowired
    private PhotoFeignService photoFeignService;
    @GetMapping("/photos")
    public ResponseEntity<List<Photo>> findAllAlbums(){
        return ResponseEntity.ok(photoFeignService.findAllPhotos());
    }

    @GetMapping("/photos/{id}")
    public ResponseEntity<Photo> findAlbumById(@PathVariable Integer id){
        return ResponseEntity.ok(photoFeignService.findPhotoById(id));
    }
}
