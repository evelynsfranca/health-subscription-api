package com.healthsubscriptionapi.facade.dto.employee;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import com.healthsubscriptionapi.facade.dto.address.AddressToCreateEmployeeDTO;
import com.healthsubscriptionapi.facade.dto.client.ClientToCreateEmployeeDTO;
import com.healthsubscriptionapi.facade.dto.product.ProductToCreateEmployeeDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeToGetDTO implements Serializable {

    private String id;

    private String cpf;

    private String name;

    private LocalDate admissionDate;

    private String email;

    private String weight;

    private String height;

    private BigDecimal meditationHours;

    private AddressToCreateEmployeeDTO address;

    @Valid
    @NotNull
    private ClientToCreateEmployeeDTO client;

    @Valid
    @NotEmpty
    private List<ProductToCreateEmployeeDTO> products;
}
