package com.elenakuropatkina.democrm.services;

import com.elenakuropatkina.democrm.DAO.ProductDAO;
import com.elenakuropatkina.democrm.DAO.ProductDAOImpl;
import com.elenakuropatkina.democrm.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    private ProductDAO productDAO;

        //@Autowired
        public void setProductDAO(ProductDAOImpl productDAO) {
            this.productDAO = productDAO;
        }

        public void create(String title, BigDecimal price) {
                productDAO.create(title, price);
        }

        public Product findOne(Long id) {
            return productDAO.findOne(id);
        }

        public List<Product> findAll() {
            return productDAO.findAll();
        }


        public void delete(Long id) {
            productDAO.delete(id);
        }

        public void update(Product product) {
            productDAO.update(product);
        }
}
