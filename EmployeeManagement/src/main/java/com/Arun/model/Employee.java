package com.Arun.model;

import java.util.Objects;

public class Employee {
	private int  empid;
	private String ename;
	private String job;
	private double salary;
	private long ephno;
	
	public Employee() {
		
	}
	public Employee(int empid, String ename, String job, double salary, long ephno) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.job = job;
		this.salary = salary;
		this.ephno = ephno;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public long getEphno() {
		return ephno;
	}
	public void setEphno(long ephno) {
		this.ephno = ephno;
	}
	@Override
	public int hashCode() {
		return Objects.hash(empid, ename, ephno, job, salary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return empid == other.empid && Objects.equals(ename, other.ename) && ephno == other.ephno
				&& Objects.equals(job, other.job)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", ename=" + ename + ", job=" + job + ", salary=" + salary + ", ephno="
				+ ephno + "]";
	}
	
	
	
	

}
