package com.elenakuropatkina.entities;

import lombok.Data;
import java.sql.Date;

@Data
public class Deal {

    private Long id;

    private Date date;

    private Long clientId;

    private Long managerId;

    private Long productId;

    private String connectionType;

    private String status;

}


