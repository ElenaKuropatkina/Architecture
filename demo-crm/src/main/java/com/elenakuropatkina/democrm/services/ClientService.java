package com.elenakuropatkina.democrm.services;

import com.elenakuropatkina.democrm.DAO.ClientDAO;
import com.elenakuropatkina.democrm.entities.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientDAO clientDAO;

    public List<Client> findAll() {
        return clientDAO.findAll();
    }


    public void create(String name, String phone, String email, String notificationType) {
        clientDAO.create(name, phone, email, notificationType);
    }

    public Client findOne(Long id) {
        return clientDAO.findOne(id);
    }

    public void delete(Long id) {
        clientDAO.delete(id);
    }


    public void update(Long id, String name, String phone, String email, String notificationType) {
        clientDAO.update(id, name, phone, email, notificationType);
    }

}



