package com.example.jsonplacehoulder.controller;

import com.example.jsonplacehoulder.api.AlbumFeignService;
import com.example.jsonplacehoulder.api.TodoFeignService;
import com.example.jsonplacehoulder.api.entities.Album;
import com.example.jsonplacehoulder.api.entities.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class TodoController {

    @Autowired
    private TodoFeignService todoFeignService;
    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> findAllAlbums(){
        return ResponseEntity.ok(todoFeignService.findAllTodos());
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<Todo> findAlbumById(@PathVariable Integer id){
        return ResponseEntity.ok(todoFeignService.findTodoById(id));
    }
}
