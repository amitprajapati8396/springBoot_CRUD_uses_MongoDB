package com.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.entites.Employee;
@Repository
public interface EmpRepository extends MongoRepository<Employee,String>{

	
}
