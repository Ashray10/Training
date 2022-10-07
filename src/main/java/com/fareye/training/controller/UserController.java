package com.fareye.training.controller;

import com.fareye.training.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class UserController {

//    List<User> users = new ArrayList<>();
    HashMap<Integer, User> users = new HashMap<>();


//    @GetMapping("/abcd")
//    public String hello(){
//        return "Hello ";
//    }

    @PostMapping("/adduser")
    public HashMap<Integer, User> CreateUser(@RequestBody User user){
        int key = users.size()+1;
        users.put(key,user);
        return users;
    }
    @PutMapping("/user/{id}")
    public HashMap<Integer, User> updateUser(@PathVariable("id") int id, @RequestBody User user){
//        user.setUser_id(id);
        users.put(id, user);
        return users;
    }
    @DeleteMapping(value = "/user/{id}")
    public HashMap<Integer, User> deleteUser(@PathVariable int id) {
//        for(int i=0; i<users.size(); i++){
//            if(id==users.get(i).getUser_id()){
//                users.remove(i);
//            }
//        }

        users.remove(id);
        return users;
    }
}
