//package com.elenakuropatkina.democrm.dataMappers;
//
//
//import com.elenakuropatkina.democrm.entities.Manager;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class ManagerMapper implements RowMapper {
//
//        @Override
//        public Manager mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//            Manager manager = new Manager();
//            manager.setId(rs.getLong("id"));
//            manager.setName(rs.getString("name"));
//            manager.setPhone(rs.getString("phone"));
//            manager.setEmail(rs.getString("email"));
//            manager.setPassword(rs.getString("password"));
//            manager.setLogin(rs.getString("login"));
//            return manager;
//        }
//}
