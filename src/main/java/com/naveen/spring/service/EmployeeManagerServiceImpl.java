package com.naveen.spring.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.naveen.spring.model.Employee;
import com.naveen.spring.model.Users;
import com.naveen.spring.repository.EmployeeRepository;
import com.naveen.spring.repository.LoginRepository;

@Service(value = "userManagerService")
public class EmployeeManagerServiceImpl implements EmployeeManagerService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	LoginRepository loginRepository;

	@Transactional(propagation = Propagation.REQUIRED, value = "transactionManager")
	public void insertUser(Employee user) {
		System.out.println("In insert method !!!");
		employeeRepository.save(user);
		System.out.println("Data inserted !!!");
	}
	public List<Employee> fetchEmployees() {
		System.out.println("Inside fetchEmployees method !!!");
		List<Employee> empList = (List<Employee>) employeeRepository.findAll();
		System.out.println("Checking list size " + empList);
		return empList;
	}

	public void deleteEmployee(long id) {
		System.out.println("Inside deleteEmployee method !!!");
		employeeRepository.delete(id);
		System.out.println("Delete employee !!!");
	}

	public void updateEmployee(Employee user) {
		System.out.println("Inside updateEmployee method !!!");
		employeeRepository.save(user);
		System.out.println("Employee updated !!!");
	}

	public boolean login(Users loginUser) {
		System.out.println("Inside login method !!!");
		Set<Users> allUsers = new HashSet<Users>();
		
		allUsers = loginRepository.findAllEmployee();
		System.out.println("List size of Users : "+ allUsers.size());
		for (Users users : allUsers) {
			if(loginUser.getUsername().equalsIgnoreCase(users.getUsername())
					&& loginUser.getPassword().equalsIgnoreCase(users.getPassword())){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
}
