package com.elenakuropatkina.democrm.services;

import com.elenakuropatkina.democrm.DAO.ManagerDAO;
import com.elenakuropatkina.democrm.entities.Manager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManagerService {

    private final ManagerDAO managerDAO;

    public List<Manager> findAll() {
        return managerDAO.findAll();
    }


    public void create(String name, String phone, String email, String password, String login) {
        managerDAO.create(name, phone, email, password, login);
    }

    public Manager findOne(Long id) {
        return managerDAO.findOne(id);
    }

    public void delete(Long id) {
        managerDAO.delete(id);
    }


    public void update(Long id, String name, String phone, String email, String password, String login) {
        managerDAO.update(id, name, phone, email, password, login);
    }

}
