package com.elenakuropatkina.democrm.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;


@RequiredArgsConstructor
@Data
public class Product {

    @Id
    private Long id;

    private String title;

    private String phone;

    private BigDecimal price;

}
