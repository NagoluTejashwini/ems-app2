package com.capg.emsapp.services;

import java.util.List;

import com.capg.emsapp.beans.Employee;
import com.capg.emsapp.exception.EmployeeSalaryException;

public interface IEmployeeService {
	public boolean insertEmployee(Employee e)throws EmployeeSalaryException;
	public List<Employee> getAllEmployees();
	public List<Employee> getAllEmployeesBySalary(int range1,int range2);
	public List<Employee> getEmployeeById(int id);
}
