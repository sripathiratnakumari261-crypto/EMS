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


@WebServlet("/edituser")
public class EditEmployee extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee= new Employee();
		employee.setId(Integer.parseInt(request.getParameter("id")));
		employee.setName(request.getParameter("name"));
		employee.setEmail(request.getParameter("email"));
		employee.setAge(Integer.parseInt(request.getParameter("age")));
		employee.setGender(request.getParameter("gender"));
		employee.setMobile(request.getParameter("mobile"));
		employee.setDepartment(request.getParameter("department"));
		employee.setAddress(request.getParameter("address"));
		
		EmployeeDAO dao= new EmployeeDAO();
		
		try {
			boolean status=dao.editEmployee(employee);
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
