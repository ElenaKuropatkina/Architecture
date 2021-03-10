package com.elenakuropatkina.documents;

import com.elenakuropatkina.DAO.ProductDAOImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.sql.Date;

public class Report implements Document{

    private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);

    public Date date;
    public String clientName;
    public String managerName;
    public String productTitle;
    public BigDecimal sum;
    public String connectionType;
    public String status;

    public Report(Date date,
                  String clientName,
                  String managerName,
                  String productTitle,
                  BigDecimal sum,
                  String connectionType,
                  String status) {
        this.date = date;
        this.clientName = clientName;
        this.managerName = managerName;
        this.productTitle = productTitle;
        this.sum = sum;
        this.connectionType = connectionType;
        this.status = status;
    }

    @Override
    public void printDoc() {
        logger.info("Report print");
    }
}
