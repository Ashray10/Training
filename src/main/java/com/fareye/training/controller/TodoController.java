package com.fareye.training.controller;


import com.fareye.training.model.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    List<Todo> Todos = new ArrayList<>();

    @GetMapping("/todo")
    public List<Todo> get_todo(){
        return Todos;
    }

    @PostMapping("/addtodo")
    public List<Todo> createUser(@RequestBody Todo todo){
        Todos.add(todo);
        return Todos;
    }

    @PutMapping("/todo/{id}")
    public List<Todo> updateUser(@PathVariable("id") int id, @RequestBody Todo todo){
        todo.setTodo_id(id);
        Todos.set(id, todo);
        return Todos;
    }
}
