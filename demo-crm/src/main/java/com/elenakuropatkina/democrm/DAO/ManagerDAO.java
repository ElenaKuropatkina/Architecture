package com.elenakuropatkina.democrm.DAO;

import com.elenakuropatkina.democrm.entities.Manager;

import java.util.List;

public interface ManagerDAO {

    public void create(String name, String phone, String email, String password, String login);

    public Manager findOne(Long id);

    public List<Manager> findAll();

    public void delete(Long id);

    public void update(Long id, String name, String phone, String email, String password, String login);

}
