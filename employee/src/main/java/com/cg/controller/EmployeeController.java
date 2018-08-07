package com.cg.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.EmployeeException;
import com.cg.model.Employee;
import com.cg.service.IService;

@RestController
public class EmployeeController {
	@Autowired
	private IService service;
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee employee) throws EmployeeException{
		try {
			 service.createEmployee(employee);
		} catch (EmployeeException e) {
			throw e;
		}
		return employee;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee employee ) throws EmployeeException {
		Employee emp=null;
		try {
			emp= service.updateEmployee(employee);
		} catch (EmployeeException e) {
			throw e;
		}
		return emp;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public boolean deleteEmployee( String empId) throws EmployeeException{
		try {
			 service.deleteEmployee(empId);
		} catch (EmployeeException e) {
			throw e;
			
		}
		return true;
	}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public List<Employee> viewEmployee(Employee employee) throws EmployeeException{
		List<Employee> emp=null;
		try {
			 emp=service.viewEmployee(employee);
		} catch (EmployeeException e) {
			throw e;
		}
		return emp;
	}
	
	@RequestMapping(value="/find",method=RequestMethod.GET)
	public Optional<Employee> findEmployee(String empId) throws EmployeeException{
		Optional<Employee> emp=null;
		try {
			emp= service.findEmployee(empId);
		} catch (EmployeeException e) {
			throw e;
		}
		return emp;
	}

}
