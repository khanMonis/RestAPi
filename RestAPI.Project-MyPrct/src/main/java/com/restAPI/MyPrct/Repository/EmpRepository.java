package com.restAPI.MyPrct.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restAPI.MyPrct.entities.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer>  {
	
	public Employee getEmpById(int id);

}
