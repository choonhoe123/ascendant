package com.Ascendant.ascendant.services;

import com.Ascendant.ascendant.entity.ClientEntity;
import com.Ascendant.ascendant.model.Client;
import com.Ascendant.ascendant.repository.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService{

    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client createClient(Client client) {
        ClientEntity clientEntity = new ClientEntity();
        BeanUtils.copyProperties(client, clientEntity);
        clientRepository.save(clientEntity);
        return client;
    }
}
