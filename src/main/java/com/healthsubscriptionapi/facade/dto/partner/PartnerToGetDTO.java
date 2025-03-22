package com.healthsubscriptionapi.facade.dto.partner;

import java.io.Serializable;

import com.healthsubscriptionapi.model.enumeration.PartnerName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartnerToGetDTO implements Serializable {

    private String id;

    private PartnerName name;
}
