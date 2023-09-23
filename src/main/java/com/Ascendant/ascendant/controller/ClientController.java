package com.Ascendant.ascendant.controller;

import com.Ascendant.ascendant.model.Client;
import com.Ascendant.ascendant.services.ClientServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    private final ClientServiceImpl clientService;
    public ClientController(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/clients")
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);

    }

}
