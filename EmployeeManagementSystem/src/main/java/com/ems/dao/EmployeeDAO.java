package com.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ems.model.Employee;

public class EmployeeDAO {
	private Connection connection;

	public boolean saveEmployee(Employee employee) throws SQLException{ 
		connection=ConnectionManager.getConnection();
		
		String query="insert into employee(name, email, password, age , gender, mobile, department, address) values(?,?,?,?,?,?,?,?)";
		
		PreparedStatement ps=connection.prepareStatement(query);
		
		ps.setString(1, employee.getName());
		ps.setString(2, employee.getEmail());
		ps.setString(3, employee.getPassword());
		ps.setInt(4, employee.getAge());
		ps.setString(5, employee.getGender());
		ps.setString(6, employee.getMobile());
		ps.setString(7, employee.getDepartment());
		ps.setString(8, employee.getAddress());
		
		int count=ps.executeUpdate();
		
		if(count==1) {
			return true;
		}
		else {
			return false;
		}
		
			}
	public void commit()throws SQLException{
		connection.commit();
		connection.close();
		
	}
	public void rollback()throws SQLException{
		connection.rollback();
		connection.close();
		
	}
	public boolean checkLogin(String email, String password) throws SQLException {
		Connection connection=ConnectionManager.getConnection();
		String query="select count(*)from employee where email = ? and password =?";
		 PreparedStatement statement =connection.prepareStatement(query);
		 statement.setString(1, email);
		 statement.setString(2, password);
		 
		 ResultSet set= statement.executeQuery();
		 int count=0;
		 if(set.next()) {
			 count =set.getInt(1);
			 
			 
		 }
		 if(count==1) {
			 return true;
		 }else {
		
		return false;
	}
	}
	public List<Employee> getAllData() throws SQLException {
		 List<Employee> empList= new ArrayList<Employee>();
		 
		 Connection connection= ConnectionManager.getConnection();
		 connection.setAutoCommit(true);
		 
		 String query="select * from employee";
		 
		 PreparedStatement statement=connection.prepareStatement(query);
		  ResultSet set= statement.executeQuery();
		  
		  while(set.next()){
			  Employee emp=new Employee();
			  emp.setId(set.getInt(1));
			  emp.setName(set.getString(2));
			  emp.setEmail(set.getString(3));
		     emp.setAge(set.getInt(5));	
		     emp.setGender(set.getString(6));
		     emp.setMobile(set.getString(7));
		     emp.setDepartment(set.getString(8));
		     emp.setAddress(set.getString(9));
		     empList.add(emp);
		  }
		  return empList;
	}
	public boolean editEmployee(Employee employee) throws SQLException{
	connection=ConnectionManager.getConnection();
		
		String query="update employee set name=?, email=?, age=?, gender=?, mobile=?, department=?, address=? where id=?";
		
		PreparedStatement ps=connection.prepareStatement(query);
		
		ps.setString(1, employee.getName());
		ps.setString(2, employee.getEmail());
		ps.setInt(3, employee.getAge());
		ps.setString(4, employee.getGender());
		ps.setString(5, employee.getMobile());
		ps.setString(6, employee.getDepartment());
		ps.setString(7, employee.getAddress());
		ps.setInt(8, employee.getId());
		
		int count=ps.executeUpdate();
		
		if(count==1) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean deleteEmployee(int id)  throws SQLException{
    connection=ConnectionManager.getConnection();
		
		String query="delete from employee where id=?";
		
		PreparedStatement ps=connection.prepareStatement(query);
		
			ps.setInt(1,id);
		
		int count=ps.executeUpdate();
		
		if(count==1) {
			return true;
		}
		else {
			return false;
		}
		
	}
	public Employee searchEmployee(String email)  throws SQLException{
		
		Employee emp= new Employee();
		 
		 Connection connection= new ConnectionManager().getConnection();
		 connection.setAutoCommit(true);
		 
		 String query="select * from employee where email=?";
		 
		 PreparedStatement statement=connection.prepareStatement(query);
		 statement.setString(1,email);
		 
		  ResultSet set= statement.executeQuery();
		  
		  if(set.next()){
			 
			  emp.setId(set.getInt(1));
			  emp.setName(set.getString(2));
			  emp.setEmail(set.getString(3));
		     emp.setAge(set.getInt(5));	
		     emp.setGender(set.getString(6));
		     emp.setMobile(set.getString(7));
		     emp.setDepartment(set.getString(8));
		     emp.setAddress(set.getString(9));
		     
		  
		  }
		  return emp;
		 
	 
		
	
	}
		
		
	}
