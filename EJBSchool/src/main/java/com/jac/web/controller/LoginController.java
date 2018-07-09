package com.jac.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jac.web.dao.StudentDAO;
import com.jac.web.model.Student;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		StudentDAO student = new StudentDAO();
		Student s1 = student.getStudent(username);
		
		if(s1 == null) {
			request.setAttribute("username", null);
			request.setAttribute("error", "User does not exist!");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		
		if(password.equals(s1.getPassword())) {
			request.setAttribute("username", username);
			request.setAttribute("error", null);
			
			s1.setUsername(username);
			s1.setPassword(password);
			HttpSession session = request.getSession();
			session.setAttribute("user", s1);
			
			RequestDispatcher rd = request.getRequestDispatcher("books.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("username", null);
			request.setAttribute("error", "Wrong password");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

}
