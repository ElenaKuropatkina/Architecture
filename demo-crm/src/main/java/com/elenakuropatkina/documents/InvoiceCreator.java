package com.elenakuropatkina.documents;

import com.elenakuropatkina.DAO.DealDAO;
import com.elenakuropatkina.services.ClientService;
import com.elenakuropatkina.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Date;

@Component
@RequiredArgsConstructor
public class InvoiceCreator {

    public final DealDAO dealDAO;
    private final ClientService clientService;
    private final ProductService productService;


    public Date setDate(Long dealId) {
        return dealDAO.findOne(dealId).getDate();
    }

    public String setClientName(Long dealId) {
        Long clientId = dealDAO.findOne(dealId).getClientId();
        return clientService.findOne(clientId).getName();

    }

    public String setProductTitle(Long dealId) {
        Long productId = dealDAO.findOne(dealId).getProductId();
        return productService.findOne(productId).getTitle();

    }

    public BigDecimal setSum(Long dealId) {
        Long productId = dealDAO.findOne(dealId).getProductId();
        return productService.findOne(productId).getPrice();
    }

    public Invoice create(Long id) {
        return new Invoice(setDate(id), setClientName(id), setProductTitle(id), setSum(id));
    }

}