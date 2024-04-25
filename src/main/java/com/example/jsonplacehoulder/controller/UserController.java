package com.example.jsonplacehoulder.controller;

import com.example.jsonplacehoulder.api.UserFeignService;
import com.example.jsonplacehoulder.api.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserFeignService userFeignService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAllUsers(){
        return ResponseEntity.ok(userFeignService.findAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(userFeignService.findUserById(id));
    }
}
