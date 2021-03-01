package com.elenakuropatkina.democrm.DAO;

import com.elenakuropatkina.democrm.dataMappers.ManagerMapper;
import com.elenakuropatkina.democrm.entities.Manager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ManagerDAOImpl implements ManagerDAO {

    private final Map<Long, Manager> identityMap = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(ManagerDAOImpl.class);

    private ManagerMapper managerMapper;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ManagerDAOImpl(ManagerMapper managerMapper, JdbcTemplate jdbcTemplate) {
        this.managerMapper = managerMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(String name, String phone, String email, String password, String login) {
        String SQL = "INSERT INTO MANAGERS (name, phone, email, password, login) VALUES (?,?,?)";
        jdbcTemplate.update(SQL, name, phone, email, password, login);
        logger.info("Manager successfully created.\nName: " + name + ";\nPhone: " +
                phone + "; \nEmail: " + email + ";\nPassword: " + password + ";\nLogin: " + login + "\n");
    }

    @Override
    public Manager findOne(Long id) {
        Manager manager = identityMap.get(id);
        if (manager == null) {
            String SQL = "SELECT * FROM MANAGERS WHERE id = ?";
            manager = (Manager) jdbcTemplate.queryForObject(SQL, new Object[]{id}, managerMapper);
        }
        if (manager != null) {
            identityMap.put(id, manager);
        }
        return manager;
    }


    @Override
    public List<Manager> findAll() {
        logger.info("findAll_managers");
        String SQL = "SELECT * FROM MANAGERS";
        List<Manager> managers = jdbcTemplate.query(SQL, managerMapper);
        return managers;
    }

    @Override
    public void delete(Long id) {
        identityMap.remove(id);
        String SQL = "DELETE FROM MANAGERS WHERE id = ?";
        jdbcTemplate.update(SQL, id);
        logger.info("Manager with id: " + id + " successfully deleted");
    }

    @Override
    public void update(Long id, String name, String phone, String email, String password, String login) {
        String SQL = "UPDATE MANAGERS SET name = ?, phone = ?, email = ?, password = ?, login = ? WHERE id = ?";
        jdbcTemplate.update(SQL, name, phone, email, password, login, id);
        logger.info("Manager with id: " + id + " successfully updated.");
    }

}
