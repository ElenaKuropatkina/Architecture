package com.elenakuropatkina.notification;

import com.elenakuropatkina.DAO.ProductDAOImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ViberDecorator extends NotificationDecorator{

    private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);

    public ViberDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public void send(String msg) {
        super.send(msg);
        sendViberMessage(msg);
    }

    void sendViberMessage(String msg){
        logger.info("Отправляем сообщение через Viber " + msg);
        //some code
    }
}
