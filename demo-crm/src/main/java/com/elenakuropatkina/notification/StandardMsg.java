package com.elenakuropatkina.notification;

import com.elenakuropatkina.DAO.ProductDAOImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StandardMsg implements Notification{

    private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);

    @Override
    public void send(String msg) {
        logger.info("Отправляем сообщение на email " + msg);
        //some code
    }
}
