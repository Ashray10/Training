package com.fareye.training.service;

import com.fareye.training.model.Item;
import org.springframework.stereotype.Service;

@Service
public class MyService {
//    @Autowired(item1)
    private Item item;

    public void printItem(){
        System.out.println(item.toString());
    }
}
