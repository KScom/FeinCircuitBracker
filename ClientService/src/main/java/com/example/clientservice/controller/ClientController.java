package com.example.clientservice.controller;

import com.example.clientservice.model.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {

    private final List<Client> clients = new ArrayList<>(){{
        add( new Client("John"));
        add(new Client("Bill"));
        add(new Client("John"));
    }};

    @GetMapping("clients")
    public ResponseEntity<?> all(){
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("clients/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        return new ResponseEntity<>(clients.get(id), HttpStatus.OK);
    }

}
