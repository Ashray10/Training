package com.fareye.training.controller;

import com.fareye.training.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class UserController {

    HashMap<Integer, User> users = new HashMap<>();
    int count=0;

    @GetMapping("/user")
    @CrossOrigin("http://localhost:3000")
    public HashMap<Integer, User> getusers(){
        return users;
    }

    @GetMapping("/user/{id}")
    @CrossOrigin("http://localhost:3000")
    public User getuserbyid(@PathVariable("id") int id){
        return users.get(id);
    }

    @PostMapping("/adduser")
    @CrossOrigin("http://localhost:3000")
    public HashMap<Integer, User> CreateUser(@RequestBody User user){
        int key = ++count;
        user.setUser_id(key);
//        user.setAvatarUrl(DataFromApi.call(user.getFirstName()));
        users.put(key,user);
        TodoController.Todos.put(key, new ArrayList<>());
        return users;
    }
    @PostMapping("/add")
    public User CreateIndiUser(@RequestBody User user){
        int key = ++count;
        user.setUser_id(key);
//        user.setAvatarUrl(DataFromApi.call(user.getFirstName()));
        users.put(key,user);
        TodoController.Todos.put(key, new ArrayList<>());
        return users.get(key);
    }

    @PutMapping("/user/{id}")
    @CrossOrigin("http://localhost:3000")
    public HashMap<Integer, User> updateUser(@PathVariable("id") int id, @RequestBody User user){
        //id not found exception
        user.setUser_id(id);
        users.put(id, user);
        return users;
    }
//    @DeleteMapping(value = "/user/{id}")
//    @CrossOrigin("http://localhost:3000")
//    public HashMap<Integer, User> deleteUser(@PathVariable int id) {
//        users.remove(id);
////        Todos.remove(id);
//        TodoController.Todos.remove(id);
//        return users;
//    }

    @DeleteMapping(value = "/user/{id}")
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        users.remove(id);
//        Todos.remove(id);
        TodoController.Todos.remove(id);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
