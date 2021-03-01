package com.elenakuropatkina.democrm.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Client {

    @Id
    private Long id;

    private String name;

    private String phone;

    private String email;

    private String notificationType;

}
