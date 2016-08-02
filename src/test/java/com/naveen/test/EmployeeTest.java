package com.naveen.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.naveen.spring.model.Users;
import com.naveen.spring.repository.EmployeeRepository;
import com.naveen.spring.repository.LoginRepository;
import com.naveen.spring.service.EmployeeManagerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:**/*applicationContext.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
public class EmployeeTest extends DBSetUp{
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	LoginRepository loginRepo;
	
	@Autowired
	EmployeeManagerService empService;
	
	@Test
	public void loginTest(){
		System.out.println("Inside login test method");
		Users user = new Users();
		user.setUsername("navexen");
		user.setPassword("password");
		boolean userMatched = empService.login(user);
		if(userMatched){
			System.out.println("User matched !!!");
		}else{
			System.out.println("User not matched !!!");
		}
		System.out.println("End login method");
	}
	
	public void insert(){
		
	}
}
