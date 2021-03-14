package com.elenakuropatkina.DAO;

import com.elenakuropatkina.dataMappers.ProductMapper;
import com.elenakuropatkina.entities.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProductDAOImpl  implements ProductDAO{

    private final ConcurrentMap<Long, Product> identityMap = new ConcurrentHashMap<>();

    private final ProductMapper productMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void create(String title, BigDecimal price){
        String SQL = "INSERT INTO PRODUCTS (title, price) VALUES (?,?,?)";
        jdbcTemplate.update(SQL, title, price);
        log.info("Product successfully created.\nTitle: " + title + ";\nPrice: " +
                price + "\n");
    }

    @Override
    public Product findOne(Long id) {
        Product product = identityMap.get(id);
        if (product == null) {
            String SQL = "SELECT * FROM PRODUCTS WHERE id = ?";
            product = (Product) jdbcTemplate.queryForObject(SQL, new Object[]{id}, productMapper);
            identityMap.put(id, product);
        }

        return product;
    }

    @Override
    public List<Product> findAll() {
        log.info("findAll_products");
        String SQL = "SELECT * FROM PRODUCTS";
        List<Product> products = jdbcTemplate.query(SQL, productMapper);
        return products;
    }

    @Override
    public void delete(Long id) {
        identityMap.remove(id);
        String SQL = "DELETE FROM PRODUCTS WHERE id = ?";
        jdbcTemplate.update(SQL, id);
        log.info("Product with id: " + id + " successfully deleted");
    }

    @Override
    public void update(Long id, String title, BigDecimal price) {
        String SQL = "UPDATE PRODUCTS SET title = ?, price = ? WHERE id = ?";
        jdbcTemplate.update(SQL, title, price, id);
        log.info("Product with id: " + id + " successfully updated.");
    }

}
