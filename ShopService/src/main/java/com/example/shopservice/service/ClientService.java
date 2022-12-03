package com.example.shopservice.service;

import com.example.shopservice.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ClientService {

    private final CircuitBreakerFactory circuitBreakerFactory;
    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public ClientService(CircuitBreakerFactory circuitBreakerFactory) {
        this.circuitBreakerFactory = circuitBreakerFactory;
    }


    public List<Client> all() {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("ListClients");
        String url = "http://localhost:8080/clients/";
        Client[] clients = circuitBreaker.run(() -> restTemplate.getForObject(url, Client[].class),
                throwable -> new Client[]{new Client("SERVICE ERROR")});
        return Arrays.stream(clients).toList();
    }


    public Client getById(Integer id) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("Client");
        String url = "http://localhost:8080/clients/" + id;
        return circuitBreaker.run(() -> restTemplate.getForObject(url, Client.class),
                throwable -> new Client("SERVICE ERROR"));
    }


}
