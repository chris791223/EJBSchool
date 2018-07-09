package com.jac.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jac.web.dao.StudentDAO;
import com.jac.web.model.Student;

/**
 * Servlet implementation class StudentController
 */
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			StudentDAO stdDao = new StudentDAO();

			// Get All Students List from DB
			List<Student> studentList = stdDao.getAllStudents();

			// Set student list to request attribute
			request.setAttribute("studentList", studentList);

			RequestDispatcher rd = request.getRequestDispatcher("StudentList.jsp");
			rd.forward(request, response);

		} catch (Exception ex) {

			// Return to student list when failed
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.write(ex.getMessage() + "<br/><br/> " + "<a href='Student'>Return to Student List</a>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get values from request form
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String city = request.getParameter("city");
		String postalCode = request.getParameter("postalCode");
		

		Student student = new Student(studentId, userName, password, firstName, lastName, city, postalCode);

		try {
			StudentDAO stdDao = new StudentDAO();

			switch (studentId) {
			// Create a new student
			case 0:
				stdDao.addStudent(student);
				break;

			// Update student
			default:
				stdDao.editStudent(student);
				break;
			}

			response.sendRedirect("Student");

		} catch (Exception ex) {
			// Return to student list when failed
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.write(ex.getMessage() + "<br/> <br/>" + "<a href='Student'>Return to Student List</a>");
		}
	}

}
