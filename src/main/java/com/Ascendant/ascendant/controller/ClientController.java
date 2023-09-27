package com.Ascendant.ascendant.controller;

import com.Ascendant.ascendant.entity.CaseEntity;
import com.Ascendant.ascendant.model.Case;
import com.Ascendant.ascendant.model.Client;
import com.Ascendant.ascendant.services.ClientServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {

    private final ClientServiceImpl clientService;
    public ClientController(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/client")
    public ResponseEntity<String> createClient(@RequestBody Client client) {
        try {
            Client createdC = clientService.createClient(client);
            return ResponseEntity.ok("Case created successfully");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body("Invalid request: " + ex.getMessage());
        }
    }

    @GetMapping("/client")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/client/{id}")
    public Client findByClientId(@PathVariable long id) {
        return clientService.findByClientId(id);
    }

    @GetMapping("/client/getCase/{clientId}")
    public List<CaseEntity> findAllCasesByClientId(@PathVariable Long clientId) {
        return clientService.findAllCasesByClientId(clientId);
    }

    @PutMapping("/client/{clientId}")
    public ResponseEntity<Client> updateClient(@PathVariable Long clientId, @RequestBody Client client) {
        client = clientService.updateClient(clientId, client);
        return ResponseEntity.ok(client);
    }
}
