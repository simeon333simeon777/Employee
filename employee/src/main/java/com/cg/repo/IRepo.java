package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.model.Employee;
@Repository
public interface IRepo extends JpaRepository<Employee, String> {

	@Query("SELECT e FROM Employee e where e.empId=:id")
	Employee getEmpId(@Param("id") String id);
	
	@Query("SELECT e FROM Employee e")
	Employee viewEmployee();

	
	
}
