package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entites.Employee;
import com.app.service.EmpService;

@RestController
@RequestMapping("/api")
public class EmpController {
  @Autowired
  private EmpService service;
  
  //save Employee
  @PostMapping("/postEmp")
  public Employee saveEmp(@RequestBody Employee emp){
	  return service.saveEmp(emp);
  }
  //get Employee by id
  @GetMapping("/getEmp/{id}")
  public Optional<Employee> getEmpById(@PathVariable("id") String id){
	  return service.getEmpById(id);
  }
  //get all employee
  @GetMapping("/getEmp")
  public List<Employee> getAllEmp(){
	return service.getAllEmp();  
  }
  //delete Employee by id
  @DeleteMapping("/deleteEmp/{id}")
  public ResponseEntity<String> deleteEmpById(@PathVariable("id") String id){
	  service.deleteById(id);
	  return (ResponseEntity<String>) ResponseEntity.ok("Employee Deleted Successfully...");
  }
  //update Employee 
  @PutMapping("/updateEmp/{id}")
  public ResponseEntity<String> updateEmp(@PathVariable("id") String id,@RequestBody Employee emp){
	 service.updateEmp(emp);
	  return ResponseEntity.ok("updated successfully...");
  }
}
