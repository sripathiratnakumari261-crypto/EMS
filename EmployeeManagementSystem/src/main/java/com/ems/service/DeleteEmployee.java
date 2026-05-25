package com.ems.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.EmployeeDAO;
import com.ems.model.Employee;


@WebServlet("/delete")
public class DeleteEmployee extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		
		EmployeeDAO dao= new EmployeeDAO();
		
		try {
			boolean status=dao.deleteEmployee(id);
			RequestDispatcher dispatcher=request.getRequestDispatcher("findAll");
			if(status) {
				dao.commit();
		
			}
			else {
				dao.rollback();
				
				
			}
			dispatcher.forward(request, response);
			
		} catch (SQLException e) {
			
			System.out.println(e);
		}
		
		
		
	}

}
