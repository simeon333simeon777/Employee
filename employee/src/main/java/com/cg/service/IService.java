package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.exception.EmployeeException;
import com.cg.model.Employee;

public interface IService {
	public Employee createEmployee(Employee employee) throws EmployeeException;
	public Employee updateEmployee(Employee employee) throws EmployeeException;
	public boolean deleteEmployee(String empId) throws EmployeeException;
	public List<Employee> viewEmployee(Employee employee) throws EmployeeException;
	public Optional<Employee> findEmployee(String empId) throws EmployeeException;
	boolean validateEmployee(Employee emp) throws EmployeeException;

}
