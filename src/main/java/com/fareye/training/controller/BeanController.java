package com.fareye.training.controller;

import com.fareye.training.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanController {
    @Autowired
    private MyService myService;

    @RequestMapping("/testbean")
    public String testBeans(){
        myService.printItem();
        return "Done";
    }
}
