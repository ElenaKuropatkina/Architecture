package com.elenakuropatkina.documents;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.sql.Date;

@Slf4j
@AllArgsConstructor
public class Report implements Document{

    public Date date;
    public String clientName;
    public String managerName;
    public String productTitle;
    public BigDecimal sum;
    public String connectionType;
    public String status;

    @Override
    public void printDoc() {
        log.info("Report print");
    }
}