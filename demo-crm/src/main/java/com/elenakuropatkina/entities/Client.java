package com.elenakuropatkina.entities;

import lombok.Data;

@Data
public class Client {

    private Long id;

    private String name;

    private String phone;

    private String email;

    private String notificationType;

}
