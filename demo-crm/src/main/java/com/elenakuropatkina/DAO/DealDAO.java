package com.elenakuropatkina.DAO;

import com.elenakuropatkina.entities.Deal;

import java.sql.Date;
import java.util.List;


public interface DealDAO {

    public void create(Date date, Long clientId, Long managerId, Long productId, String connectionType, String status);

    public Deal findOne(Long id);

    public List findAll();

    public void delete(Long id);

    public void update(Long id, Date date, Long clientId, Long managerId, Long productId, String connectionType, String status);
}

