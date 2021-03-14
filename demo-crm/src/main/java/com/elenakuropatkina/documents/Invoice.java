package com.elenakuropatkina.documents;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.sql.Date;

@Slf4j
@AllArgsConstructor
public class Invoice implements Document {

    public Date date;
    public String clientName;
    public String productTitle;
    public BigDecimal sum;

    @Override
    public void printDoc() {
        log.info("Invoice print");
    }
}