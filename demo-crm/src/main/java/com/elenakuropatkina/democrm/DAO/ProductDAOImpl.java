package com.elenakuropatkina.democrm.DAO;

import com.elenakuropatkina.democrm.dataMappers.ProductMapper;
import com.elenakuropatkina.democrm.entities.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class ProductDAOImpl  implements ProductDAO{

    private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);
    private final Map<Long, Product> identityMap = new HashMap<>();

    private ProductMapper productMapper;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDAOImpl(ProductMapper productMapper, JdbcTemplate jdbcTemplate) {
        this.productMapper = productMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(String title, BigDecimal price){
        String SQL = "INSERT INTO PRODUCTS (title, price) VALUES (?,?,?)";
        jdbcTemplate.update(SQL, title, price);
        logger.info("Product successfully created.\nTitle: " + title + ";\nPrice: " +
                price + "\n");
    }

    @Override
    public Product findOne(Long id) {
        Product product = identityMap.get(id);
        if (product == null) {
            String SQL = "SELECT * FROM PRODUCTS WHERE id = ?";
            product = (Product) jdbcTemplate.queryForObject(SQL, new Object[]{id}, productMapper);
        }
        if (product != null) {
            identityMap.put(id, product);
        }
        return product;
    }



    @Override
    public List<Product> findAll() {
        logger.info("findAll_products");
        String SQL = "SELECT * FROM PRODUCTS";
        List<Product> products = jdbcTemplate.query(SQL, productMapper);
        return products;
    }

    @Override
    public void delete(Long id) {
        identityMap.remove(id);
        String SQL = "DELETE FROM PRODUCTS WHERE id = ?";
        jdbcTemplate.update(SQL, id);
        logger.info("Product with id: " + id + " successfully deleted");
    }

    @Override
    public void update(Long id, String title, BigDecimal price) {
        String SQL = "UPDATE PRODUCTS SET title = ?, price = ? WHERE id = ?";
        jdbcTemplate.update(SQL, title, price, id);
        logger.info("Product with id: " + id + " successfully updated.");
    }
}
