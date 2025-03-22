package com.healthsubscriptionapi.facade.dto.employee;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeToSimpleDTO implements Serializable {

    private String id;
}
