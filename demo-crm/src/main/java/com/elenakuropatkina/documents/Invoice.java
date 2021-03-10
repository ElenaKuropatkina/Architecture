package com.elenakuropatkina.documents;

import com.elenakuropatkina.DAO.ProductDAOImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.sql.Date;

public class Invoice implements Document {

    private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);

    public Date date;
    public String clientName;
    public String productTitle;
    public BigDecimal sum;

    public Invoice(Date date, String clientName, String productTitle, BigDecimal sum) {
        this.date = date;
        this.clientName = clientName;
        this.productTitle = productTitle;
        this.sum = sum;
    }


    @Override
    public void printDoc() {
        logger.info("Invoice print");
    }
}

