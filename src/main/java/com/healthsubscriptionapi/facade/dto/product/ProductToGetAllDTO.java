package com.healthsubscriptionapi.facade.dto.product;

import java.io.Serializable;

import com.healthsubscriptionapi.facade.dto.partner.PartnerToGetDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductToGetAllDTO implements Serializable {

    private String id;

    private String name;

    private PartnerToGetDTO partner;
}
