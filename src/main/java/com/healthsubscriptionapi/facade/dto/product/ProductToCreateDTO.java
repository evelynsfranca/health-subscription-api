package com.healthsubscriptionapi.facade.dto.product;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;

import com.healthsubscriptionapi.facade.dto.partner.PartnerToSimpleDTO;
import com.healthsubscriptionapi.model.enumeration.ProductCategoryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductToCreateDTO implements Serializable {

    @NotBlank
    private String name;

    private ProductCategoryType category;

    private PartnerToSimpleDTO partner;
}
