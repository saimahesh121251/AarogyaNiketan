package com.capgemini.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Employee;
import com.capgemini.service.IEmployeeService;

@RestController
@RequestMapping("/api/employee/")
@CrossOrigin
public class EmployeeController {

	@Autowired
	IEmployeeService iemployeeService;
	
	@GetMapping("/")
	public ResponseEntity<List<Employee>> findAll() {
		List<Employee> list = iemployeeService.findAll();
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> findById(@PathVariable int id) {
		Employee e = iemployeeService.findById(id);
		return new ResponseEntity<Employee>(e, HttpStatus.OK);
	}
	
	

	@PostMapping("/")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
		Employee e = iemployeeService.createEmployee(employee);
		return new ResponseEntity<Employee>(e, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable int id, @RequestBody Employee employee) {
		Employee e = iemployeeService.updateEmployee(employee);
		return new ResponseEntity<Employee>(e, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable int id) {
		boolean operation = iemployeeService.deleteById(id);
		return new ResponseEntity<Boolean>(operation, HttpStatus.OK);
	}

}
