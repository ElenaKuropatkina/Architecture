package com.elenakuropatkina.DAO;

import com.elenakuropatkina.dataMappers.ClientMapper;
import com.elenakuropatkina.entities.Client;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ClientDAOImpl implements ClientDAO {

    private final ConcurrentMap<Long, Client> identityMap = new ConcurrentHashMap<>();

    private final ClientMapper clientMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name, String phone, String email, String notificationType) {
        String SQL = "INSERT INTO CLIENTS (name, phone, email, notificationType) VALUES (?,?,?)";
        jdbcTemplate.update(SQL, name, phone, email, notificationType);
        log.info("Client successfully created.\nName: " + name + ";\nPhone: " +
                phone + "; \nEmail: " + email + ";\nNotificationType: " + notificationType + "\n");
    }

    @Override
    public Client findOne(Long id) {
        Client client = identityMap.get(id);
        if (client == null) {
            String SQL = "SELECT * FROM CLIENTS WHERE id = ?";
            client = (Client) jdbcTemplate.queryForObject(SQL, new Object[]{id}, clientMapper);
            identityMap.put(id, client);
        }

        return client;
    }


    @Override
    public List<Client> findAll() {
        log.info("findAll_clients");
        String SQL = "SELECT * FROM CLIENTS";
        List<Client> clients = jdbcTemplate.query(SQL, clientMapper);
        return clients;
    }

    @Override
    public void delete(Long id) {
        identityMap.remove(id);
        String SQL = "DELETE FROM CLIENTS WHERE id = ?";
        jdbcTemplate.update(SQL, id);
        log.info("Client with id: " + id + " successfully deleted");
    }

    @Override
    public void update(Long id, String name, String phone, String email, String notificationType) {
        String SQL = "UPDATE CLIENTS SET name = ?, phone = ?, email = ?, notification_type = ? WHERE id = ?";
        jdbcTemplate.update(SQL, name, phone, email, notificationType, id);
        log.info("Client with id: " + id + " successfully updated.");
    }
}


