package com.example.jsonplacehoulder.api;

import com.example.jsonplacehoulder.api.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "UserFeignService",
        url = "https://jsonplaceholder.typicode.com"
)
public interface UserFeignService {

    @GetMapping("/users")
    public List<User> findAllUsers();

    @GetMapping("/users/{id}")
    public User findUserById(@PathVariable("id") Integer id);
}
