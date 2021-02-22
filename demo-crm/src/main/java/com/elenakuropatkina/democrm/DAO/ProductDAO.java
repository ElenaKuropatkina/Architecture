package com.elenakuropatkina.democrm.DAO;

import com.elenakuropatkina.democrm.dataMappers.ProductMapper;
import com.elenakuropatkina.democrm.entities.Product;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ProductDAO {

        public void setDataSource(DataSource dataSource);

        public void create(String title, BigDecimal price);

        public Product findOne(Long id);

        public List findAll();

        public void delete(Long id);

        public void update(Product product);
    }


