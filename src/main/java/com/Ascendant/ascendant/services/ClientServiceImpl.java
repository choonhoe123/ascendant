package com.Ascendant.ascendant.services;

import com.Ascendant.ascendant.entity.CaseEntity;
import com.Ascendant.ascendant.entity.ClientEntity;
import com.Ascendant.ascendant.model.Client;
import com.Ascendant.ascendant.repository.CaseRepository;
import com.Ascendant.ascendant.repository.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{

    private ClientRepository clientRepository;
    private CaseRepository caseRepository;

    public ClientServiceImpl(ClientRepository clientRepository, CaseRepository caseRepository) {
        this.clientRepository = clientRepository;
        this.caseRepository = caseRepository;
    }

    @Override
    public Client createClient(Client client) {
        if (client.getName() == null || client.getAge() == 0 || client.getAddress() == null || client.getBirthday() == null || client.getCompany() == null) {
            throw new IllegalArgumentException("Name, age, address, birthday, and company are required fields.");
        }
        ClientEntity clientEntity = new ClientEntity();
        BeanUtils.copyProperties(client, clientEntity);
        clientRepository.save(clientEntity);
        return client;
    }
    @Override
    public Client findByClientId(Long id) {
        Optional<ClientEntity> op = clientRepository.findById(id);
        if (op.isEmpty()) {
            return null;
        } else {
            Client c = new Client();
            ClientEntity curr = op.get();
            BeanUtils.copyProperties(curr, c);
            return c;
        }
    }
    @Override
    public List<Client> getAllClients() {
        List<Client> clientList = new ArrayList<>();
        List<ClientEntity> clientEntityList = clientRepository.findAll();
        for(ClientEntity u : clientEntityList){
            Client client = new Client();
            BeanUtils.copyProperties(u, client);
            clientList.add(client);
        }
        return clientList;
    }

    @Override
    public List<CaseEntity> findAllCasesByClientId(Long clientId) {
        List<CaseEntity> caseEntity = new ArrayList<>();
        List<ClientEntity> clientEntities = clientRepository.findByClientId(clientId);
        for(ClientEntity u : clientEntities) {
            if (u.getClientId() == clientId) {
                caseEntity = u.getCases();
            }
        }
        return caseEntity;
    }

    @Override
    public Client updateClient(Long clientId, Client client) {
        ClientEntity c = clientRepository.getReferenceById(clientId);
        c.setAddress(client.getAddress());
        c.setAge(client.getAge());
        c.setBirthday(client.getBirthday());
        c.setCompany(client.getCompany());
        c.setName(client.getName());
        clientRepository.save(c);
        return client;
    }
}
