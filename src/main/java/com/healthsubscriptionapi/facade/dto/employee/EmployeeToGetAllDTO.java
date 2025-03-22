package com.healthsubscriptionapi.facade.dto.employee;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeToGetAllDTO implements Serializable {

    private String id;

    private String cpf;

    private String name;
}
