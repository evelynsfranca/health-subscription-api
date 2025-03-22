package com.healthsubscriptionapi.facade.dto.partner;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartnerToSimpleDTO implements Serializable {

    private String id;
}
