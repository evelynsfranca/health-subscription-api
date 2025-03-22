package com.healthsubscriptionapi.facade.dto.client;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientToCreateEmployeeDTO implements Serializable {

    @NotBlank
    private String id;
}
