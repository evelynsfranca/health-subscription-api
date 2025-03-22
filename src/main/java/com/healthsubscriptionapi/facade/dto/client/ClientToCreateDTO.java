package com.healthsubscriptionapi.facade.dto.client;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientToCreateDTO implements Serializable {

    @NotBlank
    private String name;
}
