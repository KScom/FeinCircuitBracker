package com.example.shopservice.controller;

import com.example.shopservice.model.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemController {

    private final List<Item> items = new ArrayList<>(){{
        add(new Item("Television"));
        add(new Item("Coffee machine"));
        add(new Item("Bike"));
    }};

    @GetMapping("/items")
    public ResponseEntity<?> all(){
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("items/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        if(id<=items.size()) {
            return new ResponseEntity<>(items.get(id), HttpStatus.OK);
        }
        return new ResponseEntity<>("NOT FOUND", HttpStatus.BAD_REQUEST);
    }

}
