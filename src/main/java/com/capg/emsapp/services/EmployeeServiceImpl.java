package com.capg.emsapp.services;

import java.util.List;

import com.capg.emsapp.beans.Employee;
import com.capg.emsapp.dao.EmployeeDAOImpl;
import com.capg.emsapp.dao.IEmployeeDAO;
/*
 * Includes all functional and non functional req including business logic
 * 
 * */
import com.capg.emsapp.exception.EmployeeSalaryException;

public class EmployeeServiceImpl implements IEmployeeService {
IEmployeeDAO dao;
	
	public EmployeeServiceImpl() {
		dao = new EmployeeDAOImpl();
		// Animal a = new Dog();
	}

	public boolean insertEmployee(Employee e) throws EmployeeSalaryException{
		
		
		// code to log the entry of entry
		
		// code for security layer if any
		
		// code for data validation if any
		
		if(e.getSalary()>5000000)
		{
			throw new EmployeeSalaryException();
		}
		// code for data insertion into database
		
		boolean isInserted = dao.insertEmployee(e);
		
		
		// code to log all data insertion return statement
		
		return isInserted;
	}

	public List<Employee> getAllEmployees() {
		
		
		return dao.getAllEmployees();
	}

	public List<Employee> getAllEmployeesBySalary(int range1,int range2) {
		
		return dao.getAllEmployeesBySalary(range1, range2);
	}

	public List<Employee> getEmployeeById(int id) {
		
		return dao.getEmployeeById(id);
	}

}
