package com.user.controller;

import com.user.exception.ClientNotFoundException;
import com.user.model.Client;
import com.user.repositories.ClientRepository;
import com.user.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin //tells react application or spring boot to connect the two application

public class ClientController {
    @Autowired
    public ClientService clientService;
    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("/client")
    public String addClient(@RequestBody Client newClient) {
        clientService.saveClient(newClient);
        return "New Client Added";
    }


    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/client/{id}")
    public Client getClientById(@PathVariable int id) {
        return clientRepository.findById(id)
                .orElseThrow(()->new ClientNotFoundException(id));
    }

    @PutMapping("/client/{id}")
    Client updateClient(@RequestBody Client newClient, @PathVariable int id) {
        return clientRepository.findById(id)
                .map(client -> {
                    client.setFullName(newClient.getFullName());
                    client.setAddress(newClient.getAddress());

                    return clientRepository.save(client);
                }).orElseThrow(()->new ClientNotFoundException(id));
    }

    @DeleteMapping("/client/{id}")
    String deleteClient(@PathVariable int id) {
        if(!clientRepository.existsById(id)) {
            throw new ClientNotFoundException(id);
        }
        clientRepository.deleteById(id);
        return "Client with id "+id+" has been deleted successfully.";
    }

}
