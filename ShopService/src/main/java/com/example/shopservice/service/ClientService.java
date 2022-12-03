package com.example.shopservice.service;

import com.example.shopservice.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientService {

    private final CircuitBreakerFactory circuitBreakerFactory;

    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public ClientService(CircuitBreakerFactory circuitBreakerFactory) {
        this.circuitBreakerFactory = circuitBreakerFactory;
    }

    public Client getById(Integer id) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
        String url = "http://localhost:8080/clients/" + id;

        return circuitBreaker.run(() -> restTemplate.getForObject(url, Client.class) , throwable -> errorClientResponse());
    }

    private Client errorClientResponse() {
    return new Client("SERVICE ERROR");
    }


}
