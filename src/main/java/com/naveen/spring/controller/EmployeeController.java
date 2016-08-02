package com.naveen.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.spring.model.Employee;
import com.naveen.spring.service.EmployeeManagerService;

@RestController
//@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	EmployeeManagerService userService;

	@RequestMapping(value = "/RegisterEmployee", method = {
			RequestMethod.POST, RequestMethod.PUT }, consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Employee submit(@RequestBody Employee emp) {
		System.out.println("******* In Save Method **********");
//		Employee emp = new Employee();
		System.out.println("Creating employee : "+emp.getName());
//		emp.setName("gaurav");
//		emp.setUsername("gaurav1234");
//		emp.setEmail("gaurav@mastek.com");
		userService.insertUser(emp);
		System.out.println("Employee created !!!");
		return emp;
	}
	
	@RequestMapping(value = "/EmployeesList", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Employee> fetchEmployees(){
		System.out.println("******* In Fetch Method **********");
		List<Employee> employeeList = userService.fetchEmployees();
		return employeeList;
		
	}
	
	@RequestMapping(value = "/DeleteEmployee/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteEmployee(@PathVariable("id") long id){
		System.out.println("******* In Delete Method **********");
		System.out.println("Deleting employee id "+ id);
		userService.deleteEmployee(id);
		System.out.println("Employee deleted !!!");
	}
	
	@RequestMapping(value = "/UpdateEmployee", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Employee updateEmployee(@RequestBody Employee emp){
		System.out.println("******* In Update Method **********");
		System.out.println("Employee to be update "+ emp.getName());
		userService.updateEmployee(emp);
		System.out.println("Employee updated !!!");
		return emp;
	}
	
}
