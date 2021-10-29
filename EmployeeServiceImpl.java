package com.capbranding.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capbranding.entities.Employee;
import com.capbranding.exceptions.EmployeeNotFoundException;
import com.capbranding.repositories.EmployeeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
@Transactional

public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired(required = true)
	EmployeeRepository empRepo;

	Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
	public Employee addEmployee(Employee emp) {
		logger.info("Employee addEmployee()");
		if(emp == null)
			throw new EmployeeNotFoundException("No Employee Found");
		empRepo.save(emp);
		return emp;
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		logger.info("Employee updateEmployee()");
		if(emp == null)
			throw new EmployeeNotFoundException("No Employee Found");
		else {
			empRepo.save(emp);
			return emp;
		}
	}

	@Override
	public Employee removeEmployee(Integer empId) {
		logger.info("Employee removeCustomer()");
		Optional<Employee> emp = empRepo.findById(empId);
		if(!emp.isPresent())
			throw new EmployeeNotFoundException("No Employee Found");
		else {
			empRepo.deleteById(empId);
			return emp.get();
		}
	}

	@Override
	public Employee viewEmployee(Integer empId) {
		logger.info("Employee viewEmployeeById()");
		Optional<Employee> emp =  empRepo.findById(empId);
		if(!emp.isPresent())
			throw new EmployeeNotFoundException("No Employee Found");
		else 
			return emp.get();
	}

	@Override
	public List<Employee> ViewAllEmployees(String location) {
		logger.info("Employee viewEmployeeByLocation()");
		List<Employee> emp = empRepo.viewAllEmployee(location);
		if(emp.isEmpty())
			throw new EmployeeNotFoundException("No Employee Found");
		return emp;
	}

	@Override
	public List<Employee> viewAllEmployee() {
		logger.info("Employee viewAllEmployee()");
		List<Employee> employees = empRepo.findAll();
		if(employees.isEmpty())
			throw new EmployeeNotFoundException("No Employee Found");
		return employees;
	}

}