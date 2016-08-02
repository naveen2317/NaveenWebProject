/*package com.naveen.spring.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.naveen.spring.model.Employee;
import com.naveen.spring.model.Users;
import com.naveen.spring.service.EmployeeManagerService;

public class Test {
public static void main(String[] args) {
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	System.out.println("Hello !!!!");
	EmployeeManagerService managerService = (EmployeeManagerService) ctx.getBean("userManagerService");
	
	System.out.println("Context ready !!!");
	for(int i=1; i<=5;i++){
	Employee employee = new Employee();
	System.out.println("Setting data!!!");
	employee.setName("Naveen"+i);
	employee.setUsername("Naveen12910"+i);
	managerService.insertUser(employee);
	}
	Users user = new Users();
	user.setUsername("naveen");
	user.setPassword("password");
	boolean userMatched = managerService.login(user);
	if(userMatched){
		System.out.println("User matched !!!");
	}else{
		System.out.println("User not matched !!!");
	}
	System.out.println("Method ends");
}
}
*/