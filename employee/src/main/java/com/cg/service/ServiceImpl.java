package com.cg.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.Employee;
import com.cg.repo.IRepo;
@Service
public class ServiceImpl implements IService {
	@Autowired
	private IRepo repo;

	@Override
	public Employee createEmployee(Employee employee) {
		
		return repo.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee emp=repo.getEmpId(employee.getEmpId());
		
		if(employee.getEmpName()!=null) {
		emp.setEmpName(employee.getEmpName());
		}
		else {
			emp.getEmpName();
		}
		if(employee.getSalary()!=null) {
			emp.setSalary(employee.getSalary());
		}
		else {
			emp.getSalary();
		}
		if(employee.getEmpId()!=null) {
			emp.setEmpId(employee.getEmpId());
		}
		else {
			emp.getEmpId();
		}
		
		repo.save(emp);
		return emp;
	}

	@Override
	public boolean deleteEmployee(String empId) {
		repo.deleteById(empId);
		return true;
	}

	@Override
	public List<Employee> viewEmployee(Employee employee) {
		
		return repo.findAll();
	}

	@Override
	public Optional<Employee> findEmployee(String empId) {
		
		return repo.findById(empId);
	}
	
	

	
	



}
