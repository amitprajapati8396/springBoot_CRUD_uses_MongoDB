package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entites.Employee;
import com.app.repository.EmpRepository;

@Service
public class EmpService {
	@Autowired
   private EmpRepository repo;
	
	//save emp into DB
	public Employee saveEmp(Employee emp){
	 //auto generate id 	
	  emp.setId(UUID.randomUUID().toString());	
	  return repo.save(emp);	
	}
	//get employee by Id
	public Optional<Employee> getEmpById(String id){
	  return repo.findById(id);	
	}
	//get All employees
	public List<Employee> getAllEmp(){
		return repo.findAll();
	}
	//delete employee by id
    public void deleteById(String id){
    	 repo.deleteById(id);
    	
    }
    //update employee
    public void updateEmp(Employee emp){
  	   	repo.save(emp);	
    }
}
