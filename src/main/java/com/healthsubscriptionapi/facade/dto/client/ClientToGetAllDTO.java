package com.healthsubscriptionapi.facade.dto.client;

import java.io.Serializable;
import java.util.List;

import com.healthsubscriptionapi.facade.dto.product.ProductToGetAllDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientToGetAllDTO implements Serializable {

    private String id;

    private String name;

    private List<ProductToGetAllDTO> products;
}
