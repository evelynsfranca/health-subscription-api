package com.healthsubscriptionapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.healthsubscriptionapi.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
