package com.elenakuropatkina.notification;

import com.elenakuropatkina.DAO.ProductDAOImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmsDecorator extends NotificationDecorator {

    private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);

    public SmsDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public void send(String msg) {
        super.send(msg);
        sendSms(msg);
    }

    void sendSms(String msg) {
        logger.info("Отправляем SMS " + msg);
        //some code
    }

}
