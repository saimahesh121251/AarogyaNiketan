package com.capbranding.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.capbranding.entities.Employee;
import com.capbranding.services.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/Onlineshopping")

public class EmployeeController {
	
	
	@Autowired(required = true)
	private EmployeeService employeeService;

	Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@PostMapping("/employee")
	public Employee addEmployee(@Valid @RequestBody Employee emp){
		logger.info("Employee addEmployee()");
		Employee Employees = employeeService.addEmployee(emp);
		return Employees;
	}	


	@GetMapping("/employee")
	public List<Employee> viewAllEmployee()
	{
		logger.info("Employee viewAllEmployee()");
		return employeeService.viewAllEmployee();
	}

	@PutMapping("/employee")
	public Employee updateCustomer(@Valid @RequestBody Employee emp) {
		logger.info("Employee updateEmployee()");
		Employee employees = employeeService.updateEmployee(emp);
		return employees;

	}


	@GetMapping("/employee/{empId}")
	public Employee viewEmployeeById(@PathVariable("empId")int empId)
	{
		logger.info("Employee viewEmployeeById()");
		return employeeService.viewEmployee(empId);
	}
	
	/*
	@GetMapping("/employee/{employeeAddress}")
    public List<Employee> viewEmployeeByAddress(@PathVariable("wmployeeAddress")String empAddress)
    {
    logger.info("Employee viewEmployeeByLocation()");
        return employeeService.ViewAllEmployees(empAddress);
    }
	 */
	
	
	@DeleteMapping("/employee/{empId}")
	public Employee removeEmployee(@PathVariable("empId")int empId) {

		logger.info("Employee removeEmployee()");
		return employeeService.removeEmployee(empId);

	}

}