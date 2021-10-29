package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Employee;
import com.capgemini.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee findById(int id) {
		Employee e = employeeRepository.findById(id).get();
		return e;
	}
	
	@Override
	public List<Employee> findAll() {
		// return employeeRepository.findAll();
		return employeeRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
	}

	@Override
	public Employee createEmployee(Employee employee) {
		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public boolean deleteById(int id) {
		employeeRepository.deleteById(id);
		return true;
	}

	@Override
	public Employee updateEmployee(Employee employee) {

		// !GETTING FIRST AND THEN UPDATE
		employeeRepository.save(employee);
		
		return employee;
	}

	

}
