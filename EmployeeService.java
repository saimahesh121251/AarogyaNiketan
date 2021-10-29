package com.capbranding.services;

import java.util.List;

import com.capbranding.entities.Employee;

public interface EmployeeService {
	
public Employee addEmployee(Employee emp);
	
	public Employee updateEmployee(Employee emp);
	
	public Employee removeEmployee(Integer empId);
	
	public Employee viewEmployee(Integer empId);
	
	public List<Employee> ViewAllEmployees(String location);
	
	public List<Employee> viewAllEmployee();


}