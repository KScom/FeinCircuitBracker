package com.example.clientservice.service;

import com.example.clientservice.model.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemFallback implements ItemService {
    @Override
    public Item getItem(int id) {
        return new Item("SERVICE NOT WORK");
    }

    @Override
    public List<Item> getAllItems() {
        return new ArrayList<>(){{
            add(new Item("SERVICE NOT WORK"));
            add(new Item("SERVICE NOT WORK"));
            add(new Item("SERVICE NOT WORK"));
        }};
    }
}
