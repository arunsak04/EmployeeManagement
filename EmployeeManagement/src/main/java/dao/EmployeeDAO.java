package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

import com.Arun.model.Employee;
import myconnection.*;

public class EmployeeDAO {
 
	
	public 	boolean insertEmployee(Employee emp) throws SQLException{
		 // getting connection from myconnection package we created
		Connection	con=MyCon.getConnection();
		
		String sql;
		sql="insert into employee values(?,?,?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(sql);// throws sql exception
		 
		ps.setInt(1, emp.getEmpid());
		ps.setString(2,  emp.getEname());
		ps.setString(3,  emp.getJob());
		ps.setDouble(4, emp.getSalary());
		ps.setLong(5,emp.getEphno());
		
		if(ps.executeUpdate()>0) return true;
	return false;
	}
	
	public Employee searchByEmpId(int empid) throws SQLException {
		Connection con=null;;
		String sql;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		con=MyCon.getConnection();
		
		sql="select * from employee where empid=?";
		
		ps=con.prepareStatement(sql);
		
		ps.setInt(1, empid);
		
		rs=ps.executeQuery();
		
		Employee emp=new Employee();
		if(rs.next()) {
			emp.setEmpid(rs.getInt(1));
			emp.setEname(rs.getString(2));
			emp.setJob(rs.getString(3));
			emp.setSalary(rs.getDouble(4));
			emp.setEphno(rs.getLong(5));
		}else {
			emp=null;
		}
		return emp;
		
	}
	public  boolean deleteByEmpId(int empid) throws SQLException{
		Connection con=null;
		String sql;
		PreparedStatement ps=null;
		
		con=MyCon.getConnection();
		sql="delete from employee where empid=?";
		ps=con.prepareStatement(sql);
		
		ps.setInt(1, empid);
		if(ps.executeUpdate()>0) return true;
	
	return false;	
	}
	public ArrayList<Employee> searchAll() throws SQLException{
		Connection con=null;
		String sql;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		con=MyCon.getConnection();
		sql="select * from employee";
		ps=con.prepareStatement(sql);
		rs=ps.executeQuery();
		ArrayList<Employee> mylist=new ArrayList<Employee>();
		while(rs.next()) {
			Employee emp=new Employee();
			emp.setEmpid(rs.getInt(1));
			emp.setEname(rs.getString(2));
			emp.setJob(rs.getString(3));
			emp.setSalary(rs.getDouble(4));
			emp.setEphno(rs.getLong(5));
			mylist.add(emp);
			emp=null;
			
		}
		return mylist;		
}
	public  boolean updateEmployee(Employee emp) throws SQLException {
		String sql="update employee set ename=?,job=?,salary=?,ephno=? where empid=?";
		Connection con=null;
		PreparedStatement ps=null;
		con=MyCon.getConnection();
		ps=con.prepareStatement(sql);
		ps.setInt(1, emp.getEmpid());
		ps.setString(2,  emp.getEname());
		ps.setString(3,  emp.getJob());
		ps.setDouble(4, emp.getSalary());
		ps.setLong(5,emp.getEphno());
		
		if(ps.executeUpdate(sql)>0)
			return true; 
	return false;
	
	}
}
