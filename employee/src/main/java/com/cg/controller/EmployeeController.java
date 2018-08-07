package com.cg.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.Employee;
import com.cg.service.IService;

@RestController
@Transactional
public class EmployeeController {
	@Autowired
	private IService service;
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee employee) {
		return service.createEmployee(employee);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee employee ) {
		return service.updateEmployee(employee);
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public boolean deleteEmployee( String empId) {
		return service.deleteEmployee(empId);
	}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public List<Employee> viewEmployee(Employee employee){
		return service.viewEmployee(employee);
	}
	
	@RequestMapping(value="/find",method=RequestMethod.GET)
	public Optional<Employee> findEmployee(String empId){
		return service.findEmployee(empId);
	}

}
