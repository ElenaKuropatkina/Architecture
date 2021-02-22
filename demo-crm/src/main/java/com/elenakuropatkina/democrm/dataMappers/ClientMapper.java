//package com.elenakuropatkina.democrm.dataMappers;
//
//import com.elenakuropatkina.democrm.entities.Client;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class ClientMapper implements RowMapper {
//
//    @Override
//    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Client client = new Client();
//        client.setId(rs.getLong("id"));
//        client.setName(rs.getString("name"));
//        client.setPhone(rs.getString("phone"));
//        client.setEmail(rs.getString("email"));
//        client.setNotificationType(rs.getString("notification_type"));
//        return client;
//    }
//}
