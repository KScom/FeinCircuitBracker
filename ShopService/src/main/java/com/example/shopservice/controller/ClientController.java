package com.example.shopservice.controller;

import com.example.shopservice.model.Client;
import com.example.shopservice.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("clients")
    public ResponseEntity<?> all(){
        return new ResponseEntity<>(clientService.all(), HttpStatus.OK);
    }

    @GetMapping("clients/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        return new ResponseEntity<>(clientService.getById(id), HttpStatus.OK);
    }

}
