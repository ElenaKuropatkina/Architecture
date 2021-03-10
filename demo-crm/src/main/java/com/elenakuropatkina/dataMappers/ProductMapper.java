package com.elenakuropatkina.dataMappers;

import com.elenakuropatkina.entities.Product;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProductMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setId(rs.getLong("id"));
        product.setTitle(rs.getString("title"));
        product.setPrice(rs.getBigDecimal("price"));
        return product;
    }
}
