package com.Ascendant.ascendant.services;

import com.Ascendant.ascendant.entity.CaseEntity;
import com.Ascendant.ascendant.entity.ClientEntity;
import com.Ascendant.ascendant.model.Client;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public interface ClientService {
    Client createClient(Client client);

    List<Client> getAllClients();

    Client findByClientId(@PathVariable Long clientId);
    List<CaseEntity> findAllCasesByClientId(@PathVariable Long clientId);

    Client updateClient(@PathVariable Long userId, @RequestBody Client client);
}
