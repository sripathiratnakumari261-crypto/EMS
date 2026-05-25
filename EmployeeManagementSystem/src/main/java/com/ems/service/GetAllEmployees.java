package com.ems.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.EmployeeDAO;
import com.ems.model.Employee;

@WebServlet("/findAll")
public class GetAllEmployees extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeDAO dao=new EmployeeDAO();
		
		try {
			List<Employee> empList=dao.getAllData();
			RequestDispatcher dispatcher=request.getRequestDispatcher("viewemps.jsp");
			request.setAttribute("empList", empList);
			dispatcher.forward(request, response);
			
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}

}
