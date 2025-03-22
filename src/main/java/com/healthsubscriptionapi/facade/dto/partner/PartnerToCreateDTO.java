package com.healthsubscriptionapi.facade.dto.partner;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;

import com.healthsubscriptionapi.model.enumeration.PartnerName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartnerToCreateDTO implements Serializable {

    @NotBlank
    private PartnerName name;
}
