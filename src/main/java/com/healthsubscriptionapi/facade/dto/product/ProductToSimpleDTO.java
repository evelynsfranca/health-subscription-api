package com.healthsubscriptionapi.facade.dto.product;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductToSimpleDTO implements Serializable {

    private String id;
}
