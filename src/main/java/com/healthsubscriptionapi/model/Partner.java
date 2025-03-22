package com.healthsubscriptionapi.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.healthsubscriptionapi.model.enumeration.PartnerName;
import lombok.Data;

@Data
@Document
public class Partner implements Serializable {

    @Id
    private String id;

    private PartnerName name;

    @DBRef
    private List<Product> products;
}
