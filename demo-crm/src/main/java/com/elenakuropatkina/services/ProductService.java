package com.elenakuropatkina.services;

import com.elenakuropatkina.DAO.ProductDAO;
import com.elenakuropatkina.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDAO productDAO;

    public List<Product> findAll() {
        return productDAO.findAll();
    }

    public void create(String title, BigDecimal price) {
        productDAO.create(title, price);
    }

    public Product findOne(Long id) {
        return productDAO.findOne(id);
    }

    public void delete(Long id) {
        productDAO.delete(id);
    }

    public void update(Long id, String title, BigDecimal price) {
        productDAO.update(id, title, price);

    }


}

