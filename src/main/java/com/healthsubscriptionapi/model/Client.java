package com.healthsubscriptionapi.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Client implements Serializable {

    @Id
    private String id;

    private String name;

    @DBRef
    private List<Product> products;
}
