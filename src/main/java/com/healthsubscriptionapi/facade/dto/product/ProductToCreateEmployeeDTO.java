package com.healthsubscriptionapi.facade.dto.product;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductToCreateEmployeeDTO implements Serializable {

    @NotBlank
    private String id;
}
