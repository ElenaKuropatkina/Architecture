package com.elenakuropatkina.DAO;

import com.elenakuropatkina.entities.Product;

import java.math.BigDecimal;
import java.util.List;


public interface ProductDAO {

        void create(String title, BigDecimal price);

        Product findOne(Long id);

        List<Product> findAll();

        void delete(Long id);

        void update(Long id, String title, BigDecimal price);

    }


