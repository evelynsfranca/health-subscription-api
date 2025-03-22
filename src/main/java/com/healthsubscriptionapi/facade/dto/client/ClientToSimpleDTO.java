package com.healthsubscriptionapi.facade.dto.client;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientToSimpleDTO implements Serializable {

    private String id;
}
