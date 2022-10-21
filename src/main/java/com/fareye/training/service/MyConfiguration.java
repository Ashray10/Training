package com.fareye.training.service;

import com.fareye.training.model.Item;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
    @Bean
    public Item getUniqueItem(){
        System.out.println("Making new item");
        return new Item(1,"Ash");
    }
}
