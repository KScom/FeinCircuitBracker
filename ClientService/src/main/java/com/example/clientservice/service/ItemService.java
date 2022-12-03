package com.example.clientservice.service;


import com.example.clientservice.model.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ShopService", fallbackFactory = ItemFallback.class, fallback = ItemFallback.class)
public interface ItemService {

    @GetMapping("/items/{id}")
    Item getItem(@PathVariable("id") int id);

    @GetMapping("/items")
    List<Item> getAllItems();

}
