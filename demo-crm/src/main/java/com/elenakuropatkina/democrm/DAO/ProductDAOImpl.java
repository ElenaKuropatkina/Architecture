package com.elenakuropatkina.democrm.DAO;

import com.elenakuropatkina.democrm.dataMappers.ProductMapper;
import com.elenakuropatkina.democrm.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDAOImpl  implements ProductDAO{

    private final Map<Long, Product> identityMap = new HashMap<>();
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(String title, BigDecimal price){
        String SQL = "INSERT INTO PRODUCTS (title, price) VALUES (?,?,?)";
        jdbcTemplate.update(SQL, title, price);
        System.out.println("Product successfully created.\nTitle: " + title + ";\nPrice: " +
                price + "\n");
    }

    @Override
    public Product findOne(Long id) {
        Product product = identityMap.get(id);
        if (product == null) {
            String SQL = "SELECT * FROM PRODUCTS WHERE id = ?";
            product = (Product) jdbcTemplate.queryForObject(SQL, new Object[]{id}, new ProductMapper());
        }
        if (product != null) {
            identityMap.put(id, product);
        }
        return product;
    }

    @Override
    public List findAll() {
        System.out.println("Find All");
        String SQL = "SELECT * FROM PRODUCTS";
        List products = jdbcTemplate.query(SQL, new ProductMapper());
        return products;
    }

    @Override
    public void delete(Long id) {
        identityMap.remove(id);
        String SQL = "DELETE FROM PRODUCTS WHERE id = ?";
        jdbcTemplate.update(SQL, id);
        System.out.println("Product with id: " + id + " successfully deleted");
    }

    @Override
    public void update(Product product) {
       //some code
    }
}
