package com.capg.emsapp.ui;

import java.util.List;
import java.util.Scanner;

import com.capg.emsapp.beans.Employee;
import com.capg.emsapp.services.EmployeeServiceImpl;
import com.capg.emsapp.services.IEmployeeService;

public class MainUIClass {
	Scanner sc;
	IEmployeeService empService;
	
	public MainUIClass() {
		empService = new EmployeeServiceImpl();
		sc = new Scanner(System.in);
	}
	public static void main(String[] args) {
		MainUIClass obj = new MainUIClass();
		Scanner sc = new Scanner(System.in);
		// menu based program 
		obj.displayAllEmployee();
		obj.insertEmployeeInforamtion();
		obj.displayAllEmployee();
		System.out.println("Enter id: ");
		int id = sc.nextInt();
		obj.displaybyId(id);
		System.out.println("Enter range1: ");
		int range1 = sc.nextInt();
		System.out.println("Enter range2: ");
		int range2 = sc.nextInt();
		obj.displaybySalaryRange(range1, range2);
	}
	
	public void insertEmployeeInforamtion()
	{
		System.out.println(" \n Enter Employee Informations \n");
		System.out.println(" Enter Employee Name ");
		String empName = sc.nextLine();
		
		System.out.println(" Enter Employee Id ");
		int id = Integer.parseInt(sc.nextLine());
		
		System.out.println(" Enter Employee Salary ");
		int salary = Integer.parseInt(sc.nextLine());
		
		System.out.println(" Enter Project  Name ");
		String projectName = sc.nextLine();
		
		Employee e = new Employee(empName, id, salary, projectName);
		
		try
		{
			boolean isInserted = empService.insertEmployee(e);
			
			// -----
		}
		catch(Exception excep)
		{
			
			System.out.println(" Contact HR "+excep);
		}
		
		
	}
	
	public void displayAllEmployee()
	{
		System.out.println("\n=========== Employees Information ===========\n");
		List<Employee> empList = empService.getAllEmployees();
		
		for (Employee employee : empList) {
			displayEmployee(employee);
		}
	}
	
	public void displayEmployee(Employee e)
	{
		System.out.println(" Name "+e.getEmpName());
		System.out.println(" ID "+e.getId());
		System.out.println(" Salary "+e.getSalary());
		System.out.println("Project Name "+e.getProjectName());
		System.out.println("\n---------------------------------------------\n");
		
		
	}
	public void displaybyId(int id) {
		System.out.println("\n=========== Employees Information by ID ===========\n");
		List<Employee> empList = empService.getEmployeeById(id);
		
		for (Employee employee : empList) {
			displayEmployee(employee);
		}
		
	}
	public void displaybySalaryRange(int range1, int range2) {
		System.out.println("\n=========== Employees Information by ID ===========\n");
		List<Employee> empList = empService.getAllEmployeesBySalary(range1, range2);
		
		for (Employee employee : empList) {
			displayEmployee(employee);
		}
		
	}
}
