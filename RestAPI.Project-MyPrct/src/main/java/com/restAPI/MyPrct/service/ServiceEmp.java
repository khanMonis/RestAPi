package com.restAPI.MyPrct.service;

import java.util.List;
import com.restAPI.MyPrct.entities.Employee;



public interface ServiceEmp  {
	
	public List<Employee> getAllEmployees();

	public Employee getEmpById(int id);
	
    public Employee addEmployee(Employee employee);
    
    public void updateEmployee(Employee employee, int empId);
    
    public void deleteEmployee(int id);


}
