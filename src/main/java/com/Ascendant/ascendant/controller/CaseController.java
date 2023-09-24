//package com.Ascendant.ascendant.controller;
//
//import com.Ascendant.ascendant.entity.CaseEntity;
//import com.Ascendant.ascendant.model.Client;
//import com.Ascendant.ascendant.services.ClientServiceImpl;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1")
//public class CaseController {
//    private final CaseServiceImpl caseService;
//    @PostMapping("/clients")
//    public Client createClient(@RequestBody Client client) {
//        return clientService.createClient(client);
//    }
//
//    @GetMapping("/clients")
//    public List<Client> getAllUsers() {
//        return clientService.getAllClients();
//    }
//
//    @GetMapping("/clients/getCase/{clientId}")
//    public List<CaseEntity> findAllLoanRequestsByUserId(@PathVariable Long clientId) {
//        return clientService.findAllCasesByClientId(clientId);
//    }
//
//    @PutMapping("/clients/{clientId}")
//    public ResponseEntity<Client> updateUser(@PathVariable Long clientId, @RequestBody Client client) {
//        client = clientService.updateClient(clientId, client);
//        return ResponseEntity.ok(client);
//    }
//}
