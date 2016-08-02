package com.naveen.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.naveen.spring.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	
}
