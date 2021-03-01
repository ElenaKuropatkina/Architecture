//package com.elenakuropatkina.democrm.dataMappers;
//
//import com.elenakuropatkina.democrm.entities.Deal;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Component;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//@Component
//public class DealMapper implements RowMapper<Deal> {
//    @Override
//    public Deal mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Deal deal = new Deal();
//        deal.setId(rs.getLong("id"));
//        deal.setDate(rs.getDate("date"));
//        deal.setClient(rs.getLong("client_id"));
//        deal.setManager(rs.getRef("manager_id"));
//        deal.setProduct(rs.getRef("product_id"));
//        deal.setConnectionType(rs.getString("connection_type"));
//        deal.setStatus(rs.getString("status"));
//        return deal;
//    }
//}
