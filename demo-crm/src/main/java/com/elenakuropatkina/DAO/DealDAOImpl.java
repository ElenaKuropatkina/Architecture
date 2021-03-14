package com.elenakuropatkina.DAO;

import com.elenakuropatkina.dataMappers.DealMapper;
import com.elenakuropatkina.entities.Deal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
@RequiredArgsConstructor
@Slf4j
public class DealDAOImpl implements DealDAO {

    private final ConcurrentMap<Long, Deal> identityMap = new ConcurrentHashMap<>();

    private final DealMapper dealMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void create(Date date, Long clientId, Long managerId, Long productId, String connectionType, String status) {
        String SQL = "INSERT INTO DEALS (date, clientId, managerId, productId, connectionType, status) VALUES (?,?,?)";
        jdbcTemplate.update(SQL, date, clientId, managerId, productId, connectionType, status);
        log.info("Deal successfully created");
    }

    @Override
    public Deal findOne(Long id) {
        Deal deal = identityMap.get(id);
        if (deal == null) {
            String SQL = "SELECT * FROM DEALS WHERE id = ?";
            deal = (Deal) jdbcTemplate.queryForObject(SQL, new Object[]{id}, dealMapper);
            identityMap.put(id, deal);
        }

        return deal;
    }


    @Override
    public List<Deal> findAll() {
        log.info("findAll_deals");
        String SQL = "SELECT * FROM DEALS";
        List<Deal> deals = jdbcTemplate.query(SQL, dealMapper);
        return deals;
    }

    @Override
    public void delete(Long id) {
        identityMap.remove(id);
        String SQL = "DELETE FROM DEALS WHERE id = ?";
        jdbcTemplate.update(SQL, id);
        log.info("Deal with id: " + id + " successfully deleted");
    }

    @Override
    public void update(Long id, Date date, Long clientId, Long managerId, Long productId, String connectionType, String status) {
        String SQL = "UPDATE DEALS SET date = ?, client_id = ?, manager_id = ?, product_id = ?, connection_type = ?, status = ? WHERE id = ?";
        jdbcTemplate.update(SQL, date, clientId, managerId, productId, connectionType, status, id);
        log.info("Deal with id: " + id + " successfully updated.");
    }
}

