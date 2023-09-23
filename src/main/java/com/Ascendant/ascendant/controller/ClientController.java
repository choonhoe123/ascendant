package com.Ascendant.ascendant.controller;

import com.Ascendant.ascendant.model.Client;
import com.Ascendant.ascendant.services.ClientServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

//    @GetMapping("/clients")
//    public List<Client> getAllUsers() {
//        return clientService.getAllClients();
//    }
//
//    @GetMapping("/clients/getCase/{clientId}")
//    public List<CaseEntity> findAllLoanRequestsByUserId(@PathVariable Long userId) {
//        return clientService.findAllLoanRequestEntities(userId);
//    }
//
//    @PutMapping("/clients/{clientId}")
//    public ResponseEntity<Client> updateUser(@PathVariable Long userId, @RequestBody Client client) {
//        client = clientService.updateClient(userId, client);
//        return ResponseEntity.ok(client);
//    }
}
