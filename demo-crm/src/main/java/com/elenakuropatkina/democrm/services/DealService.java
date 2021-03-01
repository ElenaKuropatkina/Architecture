//package com.elenakuropatkina.democrm.services;
//
//import com.elenakuropatkina.democrm.DAO.DealDAO;
//import com.elenakuropatkina.democrm.entities.Deal;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class DealService {
//
//        private final DealDAO dealDAO;
//
//        public List<Deal> findAll() {
//            return dealDAO.findAll();
//        }
//
//
//        public void create(Date date, Long clientId, Long managerId, Long productId, String connectionType, String status) {
//            dealDAO.create(date, clientId, managerId, productId, connectionType, status);
//        }
//
//        public Deal findOne(Long id) {
//            return dealDAO.findOne(id);
//        }
//
//        public void delete(Long id) {
//            dealDAO.delete(id);
//        }
//
//
//        public void update(Long id, Date date, Long clientId, Long managerId, Long productId, String connectionType, String status) {
//            dealDAO.update(id, date, clientId, managerId, productId, connectionType, status);
//        }
//
//    }
