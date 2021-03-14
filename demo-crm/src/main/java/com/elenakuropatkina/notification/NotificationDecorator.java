package com.elenakuropatkina.notification;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NotificationDecorator implements Notification{

    private Notification notification;

    @Override
    public void send(String msg) {
        notification.send(msg);
    }
}
