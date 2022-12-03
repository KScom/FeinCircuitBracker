package com.example.shopservice.util;

import com.example.shopservice.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ListClient {

    private List<Client> clients;

    public ListClient() {
        clients = new ArrayList<>();
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
