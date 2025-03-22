package com.healthsubscriptionapi.service;

import java.util.List;

import com.healthsubscriptionapi.model.Client;

public interface ClientService {

    Client save(Client client);

    Client get(String id);

    List<Client> getAll();
}
