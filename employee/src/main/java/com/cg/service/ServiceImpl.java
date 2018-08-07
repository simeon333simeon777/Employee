package com.cg.service;

import java.util.List; 
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.exception.EmployeeException;
import com.cg.model.Employee;
import com.cg.repo.IRepo;
@Service
public class ServiceImpl implements IService {
	@Autowired
	private IRepo repo;

	@Override
	public Employee createEmployee(Employee employee) throws EmployeeException {
		if(validateEmployee(employee)) {
			return repo.save(employee);
		}
		else {
			throw new EmployeeException("Please enter correct details");
		}
	}

	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeException {
		Employee emp=repo.getEmpId(employee.getEmpId());
		if(validateEmployee(employee)) {
			emp.setEmpName(employee.getEmpName());
		}
		else {
			throw new EmployeeException("Please enter a valid name");
		}
		if(validateEmployee(employee)) {

			emp.setSalary(employee.getSalary());
		}
		else {
			throw new EmployeeException("Please enter a valid salary");
		}
		if(validateEmployee(employee)) {
			emp.setEmpId(employee.getEmpId());
		}
		else {
			throw new EmployeeException("Please enter a valid employee Id");
		}
		if(validateEmployee(employee)) {
			emp.setProject(employee.getProject());
		}
		else {
			throw new EmployeeException("Please enter a valid project name");
		}
		repo.save(emp);
		return emp;
	}

	@Override
	public boolean deleteEmployee(String empId) throws EmployeeException {
		repo.deleteById(empId);
		return true;
	}

	@Override
	public List<Employee> viewEmployee(Employee employee) throws EmployeeException {

		return repo.findAll();
	}

	@Override
	public Optional<Employee> findEmployee(String empId) throws EmployeeException {

		return repo.findById(empId);
	}


	@Override
	public boolean validateEmployee(Employee employee) throws EmployeeException{
		if(employee.getEmpName().matches("[A-Z][a-z]{2,10}") && employee.getProject().matches("[A-z][a-z]{2,10}") &&
				employee.getEmpId().matches("[e][0-9]{2,}")
				&& employee.getSalary()>=0){
				
			return true;
		}
		else
			return false;
	}


	private boolean validateProject(String project) throws EmployeeException {
		if(project.isEmpty() || project == null)
			throw new EmployeeException("Name cannot be empty");
		else
			if (!project.matches("[A-Z][a-z]{2,}"))
				throw new EmployeeException("Name must contain only alphabets");
		return true;
	}

	private boolean validateEmpId(String empId) throws EmployeeException {
		if(empId.isEmpty() || empId == null)
			throw new EmployeeException("Name cannot be empty");
		else
			if (!empId.matches("[e0-9]{2,}"))
				throw new EmployeeException("Name must contain only alphabets");
		return true;
	}


	public boolean validateEmpName(String EmpName) throws EmployeeException {
		if(EmpName.isEmpty() || EmpName == null)
			throw new EmployeeException("Name cannot be empty");
		else
			if (!EmpName.matches("[A-Z][a-z]{2,}"))
				throw new EmployeeException("Name must contain only alphabets");
		return true;
	}

	public boolean validateSalary(double salary) throws EmployeeException {
		if (salary <= 0)
			throw new EmployeeException("salary must be a number greater than zero");
		return true;
	}








}
