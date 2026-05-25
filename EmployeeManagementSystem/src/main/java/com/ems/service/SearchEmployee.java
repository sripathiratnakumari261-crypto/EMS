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

@WebServlet("/findByEmail")
public class SearchEmployee extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email= request.getParameter("email");
		EmployeeDAO dao=new EmployeeDAO();
		
		
		try {
			Employee employee=dao.searchEmployee(email);
			
			if(employee.getId() != 0) {
				
				RequestDispatcher dispatcher=request.getRequestDispatcher("viewemp.jsp");
				request.setAttribute("employee", employee);
				dispatcher.forward(request, response);
				
			}
			else {
				
				RequestDispatcher dispatcher=request.getRequestDispatcher("viewemp.jsp");
				request.setAttribute("status", "employee not found....");
				dispatcher.forward(request, response);
			}
			
			
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}

}
