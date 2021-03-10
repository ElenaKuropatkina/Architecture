package com.elenakuropatkina.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.sql.Date;

@Data
public class Deal {
    @Id
    private Long id;

    private Date date;

    private Long clientId;

    private Long managerId;

    private Long productId;

    private String connectionType;

    private String status;

}


