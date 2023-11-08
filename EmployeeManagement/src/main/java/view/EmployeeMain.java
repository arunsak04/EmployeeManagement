package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.Arun.model.Employee;

import dao.EmployeeDAO;

public class EmployeeMain {
	
	Scanner sc = new Scanner(System.in);
	
	public void insertData() {
	
		try {
		EmployeeDAO sd = new EmployeeDAO();
		System.out.print("Enter the EmpId: ");
		int empid = sc.nextInt();
		System.out.print("Enter the name: ");
		String name = sc.next();
		System.out.print("Enter the Job: ");
		String job = sc.next();
		System.out.print("Enter the Salary : ");
		double sal = sc.nextDouble();
		System.out.print("Enter the phno: ");
		long phno = sc.nextLong();

		Employee emp = new Employee();

		emp.setEmpid(empid);
		emp.setEname(name);
		emp.setJob(job);
		emp.setSalary(sal);
		emp.setEphno(phno);
		
		try {
			if (sd.insertEmployee(emp))
					System.out.println("Employee deatails added Successfully.....");
		} catch (SQLException e) {
			System.err.println("Record is not Added");
			 System.out.println(e);
		}
		}catch(InputMismatchException e) {
			System.out.println(e);System.err.println("Record is not Added");
		}catch(NullPointerException e) {
			System.out.println(e);System.err.println("Record is not Added");
		}
	}
	
	public void searchData() {
	//	Scanner sc = new Scanner(System.in);
		try {
		EmployeeDAO sd = new EmployeeDAO();
		System.out.print("Enter the Employee ID : ");
		int empid=sc.nextInt();
		Employee emp=null;
		
		emp=sd.searchByEmpId(empid);
		if(emp!=null)
		{
			System.out.println("Employee Datails");
			System.out.println("---------------------------------------------");
			System.out.println("Empployee ID      : "+emp.getEmpid());
			System.out.println("Empployee Name    : "+emp.getEname());
			System.out.println("Empployee Job     : "+emp.getJob());
			System.out.println("Empployee Salary  : "+emp.getSalary());
			System.out.println("Empployee Ph.No   : "+emp.getEphno());
			System.out.println("---------------------------------------------");
		}else {
			System.err.println("Employee not found");
		}
		}catch(SQLException e) {
			System.out.println(e);
		}catch(InputMismatchException e) {
			System.out.println(e);
		}catch(NullPointerException e) {
			System.out.println(e);
		}
	}
	
	public void deleteData() {
		
		try {
		EmployeeDAO sd = new EmployeeDAO();
		System.out.print("Enter the Employee ID : ");
		int empid=sc.nextInt();
		Employee emp=null;
		emp=sd.searchByEmpId(empid);
		if(emp!=null)
		{
			System.out.println("Employee Datails");
			System.out.println("---------------------------------------------");
			System.out.println("Empployee ID      : "+emp.getEmpid());
			System.out.println("Empployee Name    : "+emp.getEname());
			System.out.println("Empployee Job     : "+emp.getJob());
			System.out.println("Empployee Salary  : "+emp.getSalary());
			System.out.println("Empployee Ph.No   : "+emp.getEphno());
			System.out.println("---------------------------------------------");
			String ch;
			System.out.println("Are you sure want to delete (yes/no)");
			ch=sc.next();
			if(ch.equalsIgnoreCase("yes")) {
				if(sd.deleteByEmpId(empid))
					System.out.println("Record is Deleted");
				else 
					System.out.println("Record is not deleted or not found");
			}
				
		}else {
			System.err.println("Employee not found");
		}
		}catch(SQLException e) {
			System.out.println(e);
		}catch(InputMismatchException e) {
			System.out.println(e);
		}catch(NullPointerException e) {
			System.out.println(e);
		}
	}
	
	public void searchAllData(){
		
		try {
		EmployeeDAO sd = new EmployeeDAO();
		ArrayList<Employee> emplist=sd.searchAll();
		Iterator<Employee> itr=emplist.iterator();
		while(itr.hasNext()){
			Employee emp=itr.next();
			System.out.println("Employee Datails");
			System.out.println("---------------------------------------------");
			System.out.println("Empployee ID      : "+emp.getEmpid());
			System.out.println("Empployee Name    : "+emp.getEname());
			System.out.println("Empployee Job     : "+emp.getJob());
			System.out.println("Empployee Salary  : "+emp.getSalary());
			System.out.println("Empployee Ph.No   : "+emp.getEphno());
			System.out.println("---------------------------------------------");
		}
		}catch(SQLException e) {
			System.out.println(e);
		}catch(InputMismatchException e) {
			System.out.println(e);
		}catch(NullPointerException e) {
			System.out.println(e);
		}
	}

	public void updateData() {
		
		try {
		EmployeeDAO sd = new EmployeeDAO();
		System.out.println("Enter the Employee ID ");
		int empid=sc.nextInt();
		Employee emp=sd.searchByEmpId(empid);
		if(emp!=null)
		{
			System.out.println("Employee Datails");
			System.out.println("---------------------------------------------");
			System.out.println("|-----Empployee ID : "+emp.getEmpid()+"-----|");
			System.out.println("1.Empployee Name    : "+emp.getEname());
			System.out.println("2.Empployee Job     : "+emp.getJob());
			System.out.println("3.Empployee Salary  : "+emp.getSalary());
			System.out.println("4.Empployee Ph.No   : "+emp.getEphno());
			System.out.println("---------------------------------------------");
			System.out.println("Enter which Field u want to edit");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.print("Enter Employee Name : ");
				String name=sc.next();
				emp.setEname(name);
				break;
			case 2:
				System.out.print("Enter Employee Job : ");
				String job=sc.next();
				emp.setJob(job);
				break;
			case 3:
				System.out.print("Enter Employee Salary : ");
				double sal=sc.nextDouble();
				emp.setSalary(sal);
				break;
			case 4:
				System.out.print("Enter Employee Phone Number : ");
				long phno=sc.nextLong();
				emp.setEphno(phno);
				break;
				default:System.err.println("Invalid Input");
				break;
			}
			if(sd.updateEmployee(emp))
				System.out.println("Record is Updated");
			else
				System.out.println("Record is Not Updated");
		}else {
			System.err.println("Employee not found");
		}
		}catch(InputMismatchException e) {
			System.out.println(e);
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	
}
