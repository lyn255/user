package com.user.services;

import com.user.model.Client;

import java.util.List;

public interface ClientService {
    public Client saveClient(Client client);
    public List<Client> getAllClients();
}
