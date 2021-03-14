package com.elenakuropatkina.DAO;

import com.elenakuropatkina.dataMappers.ManagerMapper;
import com.elenakuropatkina.entities.Manager;
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
public class ManagerDAOImpl implements ManagerDAO {

    private final ConcurrentMap<Long, Manager> identityMap = new ConcurrentHashMap<>();

    private final ManagerMapper managerMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name, String phone, String email, String password, String login) {
        String SQL = "INSERT INTO MANAGERS (name, phone, email, password, login) VALUES (?,?,?)";
        jdbcTemplate.update(SQL, name, phone, email, password, login);
        log.info("Manager successfully created.\nName: " + name + ";\nPhone: " +
                phone + "; \nEmail: " + email + ";\nPassword: " + password + ";\nLogin: " + login + "\n");
    }

    @Override
    public Manager findOne(Long id) {
        Manager manager = identityMap.get(id);
        if (manager == null) {
            String SQL = "SELECT * FROM MANAGERS WHERE id = ?";
            manager = (Manager) jdbcTemplate.queryForObject(SQL, new Object[]{id}, managerMapper);
            identityMap.put(id, manager);
        }

        return manager;
    }


    @Override
    public List<Manager> findAll() {
        log.info("findAll_managers");
        String SQL = "SELECT * FROM MANAGERS";
        List<Manager> managers = jdbcTemplate.query(SQL, managerMapper);
        return managers;
    }

    @Override
    public void delete(Long id) {
        identityMap.remove(id);
        String SQL = "DELETE FROM MANAGERS WHERE id = ?";
        jdbcTemplate.update(SQL, id);
        log.info("Manager with id: " + id + " successfully deleted");
    }

    @Override
    public void update(Long id, String name, String phone, String email, String password, String login) {
        String SQL = "UPDATE MANAGERS SET name = ?, phone = ?, email = ?, password = ?, login = ? WHERE id = ?";
        jdbcTemplate.update(SQL, name, phone, email, password, login, id);
        log.info("Manager with id: " + id + " successfully updated.");
    }
}
