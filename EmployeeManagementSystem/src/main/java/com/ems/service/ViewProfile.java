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
import javax.servlet.http.HttpSession;

import com.ems.dao.EmployeeDAO;
import com.ems.model.Employee;

@WebServlet("/viewprofile")
public class ViewProfile extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		String email=(String)session.getAttribute("email");
		EmployeeDAO dao=new EmployeeDAO();
		
		
		try {
			Employee employee=dao.searchEmployee(email);
			
				RequestDispatcher dispatcher=request.getRequestDispatcher("viewprofile.jsp");
				request.setAttribute("employee", employee);
				dispatcher.forward(request, response);
	
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}

}
