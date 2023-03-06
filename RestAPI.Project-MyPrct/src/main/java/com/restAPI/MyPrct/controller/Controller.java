 package com.restAPI.MyPrct.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restAPI.MyPrct.entities.Employee;
import com.restAPI.MyPrct.service.ServiceImpl;

@RestController
public class Controller {

	
	@Autowired
	private ServiceImpl service;
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployees() {	
			
		List<Employee> emp = this.service.getAllEmployees();
		if(emp.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(emp));
	}
	
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")int id) {
		
		Employee emp = service.getEmpById(id);
		if(emp==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return 	ResponseEntity.of(Optional.of(emp));
	}
	
	//Add new Employee by Post
	@PostMapping("/employee")
	public ResponseEntity<Employee> getEmployee(@RequestBody Employee employee) {
		
		Employee emp;
		try {
		   emp= this.service.addEmployee(employee);
		return ResponseEntity.of(Optional.empty());
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//Update Employee value handler
	@PutMapping("/employee/{empId}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable("empId")int empId) {
		
		try {
			this.service.updateEmployee(employee, empId);
          return ResponseEntity.ok().body(employee);
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}	
	}
	
	//delete book value
		@DeleteMapping("/employee/{bookId}")
		public ResponseEntity<Void> deleteBook(@PathVariable("bookId")int bookId) {
			
			try {
			this.service.deleteEmployee(bookId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
}
