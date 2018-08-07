package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.model.Employee;

public interface IService {
	public Employee createEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public boolean deleteEmployee(String empId);
	public List<Employee> viewEmployee(Employee employee);
	public Optional<Employee> findEmployee(String empId);

}
