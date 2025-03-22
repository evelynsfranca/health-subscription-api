package com.healthsubscriptionapi.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.healthsubscriptionapi.model.enumeration.ProductCategoryType;
import lombok.Data;

@Data
@Document
public class ProductCategory implements Serializable {

    @Id
    private String id;

    private ProductCategoryType name;
}
