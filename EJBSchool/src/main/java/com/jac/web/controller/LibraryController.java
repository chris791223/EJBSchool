package com.jac.web.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jac.web.dao.BookDAO;
import com.jac.web.model.Book;

/**
 * Servlet implementation class LibraryController
 */
public class LibraryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibraryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get Books
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("username", "user");	// remove this line later(when project completed)
		
		if(session.getAttribute("username") == null) {
			response.sendRedirect("index.jsp");
		}else {
			ArrayList<Book> books = (new BookDAO()).getAllBooks();
			
			request.setAttribute("books",  books);
			
			RequestDispatcher rd = request.getRequestDispatcher("books.jsp");
			rd.forward(request,  response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		if(username == null || !username.equals("teacher")) {
			RequestDispatcher rd = request.getRequestDispatcher("newBook.jsp");
			rd.forward(request,  response);
		}
		
		BookDAO bookDAO = new BookDAO();
		String command = (String)request.getParameter("command");
		if (command.equals("edit")) {
			int bId = Integer.parseInt(request.getParameter("bId"));
			String name = (String)request.getParameter("name");
			String author = (String)request.getParameter("author");
			
			if(bId == 0) {	// New Book
				bookDAO.addBook(name, author);
			}else {			// Modify Book
				bookDAO.modifyBook(bId, name, author);
			}			
			doGet(request, response);
		}else if(command.equals("delete")) {
			int bId = Integer.parseInt(request.getParameter("bId"));
			
			if(bId <= 0) {
				String error = "This book doesn't exist in our system.";
				request.setAttribute("error", error);				
			}else {
				bookDAO.deleteBook(bId);
			}			
			doGet(request, response);
		}else if (command.equals("update")) {
			int bId = Integer.parseInt(request.getParameter("bId"));
			Book book = bookDAO.getBookById(bId);
			
			request.setAttribute("book", book);
			RequestDispatcher rd = request.getRequestDispatcher("newBook.jsp");
			rd.forward(request,  response);
		}else if(command.equals("search")) {
			int option = Integer.parseInt(request.getParameter("option"));
			String keyword = request.getParameter("keyword");
			ArrayList<Book> books = null;
			if(option == 1) {
				books = bookDAO.getBooksByName(keyword);
			}else if(option == 2) {
				books = bookDAO.getBooksByAuthor(keyword);
			}
			
			request.setAttribute("books",  books);
			RequestDispatcher rd = request.getRequestDispatcher("books.jsp");
			rd.forward(request,  response);
		}
		
	}
	


}
