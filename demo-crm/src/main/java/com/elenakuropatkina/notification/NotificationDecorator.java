package com.elenakuropatkina.notification;

public class NotificationDecorator implements Notification{

    private Notification notification;

    public NotificationDecorator(Notification notification) {
        this.notification = notification;
    }

    @Override
    public void send(String msg) {
        notification.send(msg);
    }
}
