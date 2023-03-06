package com.restAPI.MyPrct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.restAPI.MyPrct.Repository.EmpRepository;
import com.restAPI.MyPrct.entities.Employee;


@Service
public class ServiceImpl implements ServiceEmp {
	
	@Autowired
	private EmpRepository empRepository;
		
//	private static  List<Employee> list=new ArrayList<>();
//	
//	static {
//		
//	}
//	
//	//get All Employee
//	public List<Employee> getAllEmp(){
//		list.add(new Employee(1,"Hamza","jairajpur","Azamgarh"));
//		list.add(new Employee(2,"Amir Alam","Chandpati","Azamgarh"));
//		list.add(new Employee(3,"Danish","Khandwari","Azamgarh"));
//		list.add(new Employee(4,"Arbaz","Karmaini","Azamgarh"));
//		return list;
//	}
//	
	
	//get All value
	public List<Employee> getAllEmployees(){
		return empRepository.findAll();
		
	}
	
	
	//get Single value
	public Employee getEmpById(int id) {
		Employee employee=null;
		try {
//		   employee = list.stream().filter(e->e.getId()==id).findFirst().get();
			employee=empRepository.getEmpById(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return employee;	
	}
	
	//Add new Books
    public Employee addEmployee(Employee employee) {
    	  
    	empRepository.save(employee);
    	
    	return employee;
    }
    
    //Update Employee value by put method
    public void updateEmployee(Employee employee, int empId) {
    	
//    	list.stream().map(emp->{
//    		if(emp.getId()==empId) {
//    			emp.setName(employee.getName());
//    			emp.setVillege(employee.getVillege());
//    			emp.setCity(employee.getCity());		
//    		}
//    		return emp;	
//    	}).collect(Collectors.toList());
    	
    	employee.setId(empId);
    	empRepository.save(employee);
    }
    
    //delete by id
    public void deleteEmployee(int id) {
    	
    	empRepository.deleteById(id);
    }
    
}
