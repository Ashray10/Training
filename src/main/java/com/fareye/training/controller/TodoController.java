package com.fareye.training.controller;


import com.fareye.training.model.Todo;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
public class TodoController {

//    List<Todo> Todos = new ArrayList<>();
public static HashMap<Integer, List<Todo>> Todos = new HashMap<>();

    @GetMapping("/todo")
    @CrossOrigin("http://localhost:3000")
    public HashMap<Integer, List<Todo>> get_todo(){
        return Todos;
    }

    @PostMapping("/addtodo")
    @CrossOrigin("http://localhost:3000")
    public HashMap<Integer, List<Todo>> createUser(@RequestBody @Valid Todo todo) throws Exception {
        if(Todos.get(todo.getUser_id())==null){
            throw new Exception("User Not Found");
        }
        Todos.get(todo.getUser_id()).add(todo);
        return Todos;
    }

    @PutMapping("/todo")
    @CrossOrigin("http://localhost:3000")
    public HashMap<Integer, List<Todo>> updateUser(@RequestBody Todo todo){
        List<Todo> usertodo = Todos.get(todo.getUser_id());
        for(int i=0; i<usertodo.size(); i++){
            if(todo.getTitle().equals(usertodo.get(i).getTitle())){
                Todos.get(todo.getUser_id()).remove(i);
            }
        }
        Todos.get(todo.getUser_id()).add(todo);
        return Todos;
    }

    @DeleteMapping(value = "/todo/{id}/{title}")
    @CrossOrigin("http://localhost:3000")
    public HashMap<Integer, List<Todo>> deleteUser(@PathVariable int id, @PathVariable String title) {
        List<Todo> usertodo = Todos.get(id);
//        Todos.get(id).remove(title);
        for(int i=0; i<usertodo.size(); i++){
            if(title.equals(usertodo.get(i).getTitle())){
                Todos.get(id).remove(i);
            }
        }
        return Todos;
    }
}
