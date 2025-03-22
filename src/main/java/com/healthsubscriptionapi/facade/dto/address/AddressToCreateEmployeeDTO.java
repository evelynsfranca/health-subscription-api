package com.healthsubscriptionapi.facade.dto.address;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressToCreateEmployeeDTO implements Serializable {

    private String street;

    private String number;

    private String complement;

    private String neighborhood;

    private String city;

    private String state;
}
