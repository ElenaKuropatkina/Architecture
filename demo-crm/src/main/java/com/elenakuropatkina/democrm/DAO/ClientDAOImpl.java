package com.elenakuropatkina.democrm.DAO;

import com.elenakuropatkina.democrm.dataMappers.ClientMapper;
import com.elenakuropatkina.democrm.entities.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ClientDAOImpl implements ClientDAO {


    private static final Logger logger = LoggerFactory.getLogger(ClientDAOImpl.class);
    private final Map<Long, Client> identityMap = new HashMap<>();

    private ClientMapper clientMapper;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientDAOImpl(ClientMapper clientMapper, JdbcTemplate jdbcTemplate) {
        this.clientMapper = clientMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(String name, String phone, String email, String notificationType) {
        String SQL = "INSERT INTO CLIENTS (name, phone, email, notificationType) VALUES (?,?,?)";
        jdbcTemplate.update(SQL, name, phone, email, notificationType);
        logger.info("Client successfully created.\nName: " + name + ";\nPhone: " +
                phone + "; \nEmail: " + email + ";\nNotificationType: " + notificationType + "\n");
    }

    @Override
    public Client findOne(Long id) {
        Client client = identityMap.get(id);
        if (client == null) {
            String SQL = "SELECT * FROM CLIENTS WHERE id = ?";
            client = (Client) jdbcTemplate.queryForObject(SQL, new Object[]{id}, clientMapper);
        }
        if (client != null) {
            identityMap.put(id, client);
        }
        return client;
    }


    @Override
    public List<Client> findAll() {
        logger.info("findAll_clients");
        String SQL = "SELECT * FROM CLIENTS";
        List<Client> clients = jdbcTemplate.query(SQL, clientMapper);
        return clients;
    }

    @Override
    public void delete(Long id) {
        identityMap.remove(id);
        String SQL = "DELETE FROM CLIENTS WHERE id = ?";
        jdbcTemplate.update(SQL, id);
        logger.info("Client with id: " + id + " successfully deleted");
    }

    @Override
    public void update(Long id, String name, String phone, String email, String notificationType) {
        String SQL = "UPDATE CLIENTS SET name = ?, phone = ?, email = ?, notification_type = ? WHERE id = ?";
        jdbcTemplate.update(SQL, name, phone, email, notificationType, id);
        logger.info("Client with id: " + id + " successfully updated.");
    }
}


