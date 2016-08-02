package com.naveen.spring.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.naveen.spring.model.Users;

@Repository
public interface LoginRepository extends CrudRepository<Users, Long>{
	
	@Query("select user from com.naveen.spring.model.Users user")
	Set<Users> findAllEmployee();
	

}
