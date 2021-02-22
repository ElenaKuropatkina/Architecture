//package com.elenakuropatkina.democrm.DAO;
//
//import com.elenakuropatkina.democrm.entities.Client;
//import com.elenakuropatkina.democrm.entities.Deal;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public interface DealDAO {
//
//    private final Map<Integer, Deal> identityMap = new HashMap<>();
//
//    public void createDeal(Date date, Long clientId, Long managerId, Long productId, String connectionType, String status);
//
//    public Deal getOne(Long id);
//
//    public List findAll();
//
//    public void delete(Long id);
//
//    public void update(Long id, Date date, Long clientId, Long managerId, Long productId, String connectionType, String status);
//}
