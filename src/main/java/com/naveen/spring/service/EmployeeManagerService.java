package com.naveen.spring.service;

import java.util.List;

import com.naveen.spring.model.Employee;
import com.naveen.spring.model.Users;

public interface EmployeeManagerService {

	void insertUser(Employee user);

	List<Employee> fetchEmployees();

	void deleteEmployee(long id);

	void updateEmployee(Employee user);
	
	boolean login(Users loginUser);
}
