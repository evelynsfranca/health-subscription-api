package com.healthsubscriptionapi.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthsubscriptionapi.facade.EmployeeFacade;
import com.healthsubscriptionapi.facade.dto.employee.EmployeeToCreateDTO;
import com.healthsubscriptionapi.facade.dto.employee.EmployeeToGetAllDTO;
import com.healthsubscriptionapi.facade.dto.employee.EmployeeToGetDTO;
import com.healthsubscriptionapi.facade.dto.employee.EmployeeToSimpleDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    private final EmployeeFacade employeeFacade;

    @PostMapping
    private ResponseEntity<EmployeeToSimpleDTO> create(@Valid @RequestBody EmployeeToCreateDTO dto) {
        EmployeeToSimpleDTO result = employeeFacade.save(dto);
        return new ResponseEntity<EmployeeToSimpleDTO>(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<EmployeeToGetDTO> get(@PathVariable String id) {
        EmployeeToGetDTO result = employeeFacade.get(id);
        return new ResponseEntity<EmployeeToGetDTO>(result, HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<List<EmployeeToGetAllDTO>> getAll() {
        List<EmployeeToGetAllDTO> result = employeeFacade.getAll();
        return new ResponseEntity<List<EmployeeToGetAllDTO>>(result, HttpStatus.OK);
    }

}
