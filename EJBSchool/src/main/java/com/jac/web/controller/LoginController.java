package com.jac.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jac.web.dao.StudentDAO;
import com.jac.web.dao.TeacherDAO;
import com.jac.web.model.Student;
import com.jac.web.model.Teacher;

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
		HttpSession session = request.getSession();
		String command = request.getParameter("command");
		if(command.equals("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			StudentDAO student = null;
			Student s1 = null;
			TeacherDAO teacher = null;
			Teacher t1 = null;
			try {
				student = new StudentDAO();
				s1 = student.getStudentByUsername(username);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(s1 == null) {
				try {
					teacher = new TeacherDAO();
					t1 = teacher.getTeacherByUsername(username);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(t1 == null) {
					session.setAttribute("username", null);
					request.setAttribute("error", "User does not exist!");
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
				
				if (password.equals(t1.getPassword())){
					session.setAttribute("username", username);
					request.setAttribute("error", null);
					
					t1.setUserName(username);
					t1.setPassword(password);
					session.setAttribute("user", t1);
					
					RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
					rd.forward(request, response);
				}else {
					session.setAttribute("username", null);
					request.setAttribute("error", "Wrong password");
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
			}
			
			if(password.equals(s1.getPassword())) {
				session.setAttribute("username", username);
				request.setAttribute("error", null);
				
				s1.setUserName(username);
				s1.setPassword(password);
				session.setAttribute("user", s1);
				
				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			}else {
				session.setAttribute("username", null);
				request.setAttribute("error", "Wrong password");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}else if(command.equals("logout")) {
			session.setAttribute("user", null);
			session.setAttribute("username", null);
			request.setAttribute("error", null);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

}
