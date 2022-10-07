package com.fareye.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@RestController
public class PropertiesController {

    @GetMapping("/properties1")
    public Properties properties(){

        Properties p = new Properties();
        try {
            p.load(new FileReader("/home/ashray/Downloads/training/src/main/resources/application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    @Autowired
    private Environment env;

    @GetMapping("/properties")
    public String prop(){
        return env.getProperty("spring.application.name");
    }
}