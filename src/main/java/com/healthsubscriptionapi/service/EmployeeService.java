package com.healthsubscriptionapi.service;

import java.util.List;

import com.healthsubscriptionapi.model.Employee;

public interface EmployeeService {

    Employee save(Employee employee);

    Employee get(String id);

    List<Employee> getAll();
}
