package com.jac.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jac.web.dao.StudentDAO;
import com.jac.web.model.Student;

/**
 * Servlet implementation class DeleteStudentController
 */
public class DeleteStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get student id from student list
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			StudentDAO stuDao = new StudentDAO();

			// Get student by ID
			Student student = stuDao.getStudentById(id);

			if (student != null) {
				request.setAttribute("student", student);

				RequestDispatcher rd = request.getRequestDispatcher("DeleteConfirmation.jsp");
				rd.forward(request, response);
			}
			// when student does not exist (in case of deletion by others)
			else {
				// Return to student list when failed
				response.setContentType("text/html");
				PrintWriter pw = response.getWriter();
				pw.write("Student does not exist." + "<br/><br/> " + "<a href='Student'>Return to Student List</a>");
			}

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

		try {
			StudentDAO stuDao = new StudentDAO();

			stuDao.deleteStudent(studentId);

			response.sendRedirect("Student");

		} catch (Exception ex) {
			// Return to student list when failed
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.write(ex.getMessage() + "<br/> <br/>" + "<a href='Student'>Return to Student List</a>");
		}
	}

}
