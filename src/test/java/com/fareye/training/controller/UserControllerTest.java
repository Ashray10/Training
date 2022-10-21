package com.fareye.training.controller;

import com.fareye.training.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserControllerTest {

    @Test
    void createUser() {
        RestTemplate restTemplate = new RestTemplate();
        User user = new User();
        user.setBloodGroup("A");
        user.setName("Tom");
        user.setPhone("00000000");
        user.setStandard("High");
        User response = restTemplate.postForObject("http://localhost:8080/add", user, User.class);
//        System.out.println("complete");
        assertEquals("Tom", response.getName());
//        assertEquals(4, 2+2);
    }

    @Test
    void getuserbyid() {
        RestTemplate restTemplate = new RestTemplate();
//        User user = new User();
//        user.setBloodGroup("A");
//        user.setName("Tom");
//        user.setPhone("00000000");
//        user.setStandard("High");
//        User serverUser = restTemplate.postForObject("http://localhost:8080/add", user, User.class);
        User response = restTemplate.getForObject("http://localhost:8080/user/1", User.class);
        assertEquals("asdfafs", response.getName());
    }

    @Test
    void updateUser() {
        RestTemplate restTemplate = new RestTemplate();
//        User user = new User();
//        user.setBloodGroup("A");
//        user.setName("Tom");
//        user.setPhone("00000000");
//        user.setStandard("High");
//        restTemplate.postForObject("http://localhost:8080/add", user, User.class);
        User newUser = new User();
        newUser.setBloodGroup("O");
        newUser.setName("Jerry");
        newUser.setPhone("00000001");
        newUser.setStandard("Low");
        restTemplate.put("http://localhost:8080/user/1", newUser);
//        System.out.println("Hello");
//        assertEquals(4, 2+2);
        User response = restTemplate.getForObject("http://localhost:8080/user/1", User.class);
        assertEquals("Jerry", response.getName());
    }
//
    @Test
    void deleteUser() {
        RestTemplate restTemplate = new RestTemplate();
        User user = new User();
        user.setBloodGroup("A");
        user.setName("Tom");
        user.setPhone("00000000");
        user.setStandard("High");
        restTemplate.postForObject("http://localhost:8080/add", user, User.class);
        User newUser = new User();
        newUser.setBloodGroup("O");
        newUser.setName("Jerry");
        newUser.setPhone("00000001");
        newUser.setStandard("Low");
        restTemplate.delete("http://localhost:8080/user/1");
    }
}