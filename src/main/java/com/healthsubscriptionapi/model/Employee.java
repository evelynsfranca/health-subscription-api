package com.healthsubscriptionapi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Employee implements Serializable {

    @Id
    private String id;

    private String cpf;

    private String name;

    private LocalDate admissionDate;

    private String email;

    private String weight;

    private String height;

    private BigDecimal meditationHours;

    @DBRef
    private Address address;

    @DBRef
    private Client client;

    @DBRef
    private List<Product> products;
}
