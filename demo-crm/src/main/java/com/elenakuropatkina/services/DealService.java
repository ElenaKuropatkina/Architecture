package com.elenakuropatkina.services;

import com.elenakuropatkina.DAO.DealDAO;
import com.elenakuropatkina.documents.Document;
import com.elenakuropatkina.documents.InvoiceCreator;
import com.elenakuropatkina.documents.ReportCreator;
import com.elenakuropatkina.entities.Deal;
import com.elenakuropatkina.notification.NotificationDecorator;
import com.elenakuropatkina.notification.SmsDecorator;
import com.elenakuropatkina.notification.StandardMsg;
import com.elenakuropatkina.notification.ViberDecorator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DealService {

    private final DealDAO dealDAO;
    private final InvoiceCreator invoiceCreator;
    private final ReportCreator reportCreator;

    public List<Deal> findAll() {
        return dealDAO.findAll();
    }

    public void create(Date date, Long clientId, Long managerId, Long productId, String connectionType, String status) {
        dealDAO.create(date, clientId, managerId, productId, connectionType, status);
    }

    public Deal findOne(Long id) {
        return dealDAO.findOne(id);
    }

    public void delete(Long id) {
        dealDAO.delete(id);
    }


    public void update(Long id, Date date, Long clientId, Long managerId, Long productId, String connectionType, String status) {
        dealDAO.update(id, date, clientId, managerId, productId, connectionType, status);
    }

    public Document createInvoice(Long id) {
        return invoiceCreator.create(id);
    }

    public Document createReport(Long id) {
        return reportCreator.create(id);
    }

    public void sendNotificationForClient(String msg) {
        NotificationDecorator notificationDecorator = new ViberDecorator(new SmsDecorator(new StandardMsg()));
        notificationDecorator.send(msg);
    }

}
