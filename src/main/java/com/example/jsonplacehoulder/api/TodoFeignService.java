package com.example.jsonplacehoulder.api;

import com.example.jsonplacehoulder.api.entities.Album;
import com.example.jsonplacehoulder.api.entities.Todo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(
        name = "TodoFeignService",
        url = "https://jsonplaceholder.typicode.com"
)
public interface TodoFeignService {

    @GetMapping("/todos")
    public List<Todo> findAllTodos();
    @GetMapping("/todos/{id}")
    public Todo findTodoById(@PathVariable Integer id);
}
