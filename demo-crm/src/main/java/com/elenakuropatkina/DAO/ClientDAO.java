package com.elenakuropatkina.DAO;

import com.elenakuropatkina.entities.Client;

import java.util.List;

public interface ClientDAO {

    public void create(String name, String phone, String email, String notificationType);

    public Client findOne(Long id);

    public List<Client> findAll();

    public void delete(Long id);

    public void update(Long id, String name, String phone, String email, String notificationType);
}
