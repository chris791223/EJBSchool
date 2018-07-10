package com.jac.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jac.web.model.Book;

public class BookDAO {
	public static Connection connect() {
		Connection con = null;
		String url = "jdbc:mysql://den1.mysql5.gear.host/ejbs";
		String user = "ejbs";
		String pass = "tp%ipd12";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("Connnected!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}
	
	public void registerBook() {
		Connection con = connect();
		
	}
	
	public ArrayList<Book> getAllBooks(){
		Connection con = connect();
		ArrayList<Book> books = new ArrayList<Book>();
		
		try {
			String query = "SELECT * FROM books";
			Statement st = con.createStatement();
		
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				int idFromDB = rs.getInt("id");
				String nameFromDB = rs.getString("name");
				String authorFromDB = rs.getString("author");
				
				Book book = new Book();
				book.setId(idFromDB);
				book.setName(nameFromDB);
				book.setAuthor(authorFromDB);
				
				books.add(book);
			}
			
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return books;
	}
	
	public Book getBookById(int id){
		Connection con = connect();
		Book book = null;
		
		try {
			String query = "SELECT * FROM books WHERE id=" + id;
			Statement st = con.createStatement();
		
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				int idFromDB = rs.getInt("id");
				String nameFromDB = rs.getString("name");
				String authorFromDB = rs.getString("author");
				
				book = new Book();
				book.setId(idFromDB);
				book.setName(nameFromDB);
				book.setAuthor(authorFromDB);
			}
			
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return book;
	}
	public ArrayList<Book> getBooksByName(String keyword){
		Connection con = connect();
		ArrayList<Book> books = new ArrayList<Book>();
		
		try {
			String query = "SELECT * FROM books WHERE name LIKE '%" + keyword + "%'";
			Statement st = con.createStatement();
		
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				int idFromDB = rs.getInt("id");
				String nameFromDB = rs.getString("name");
				String authorFromDB = rs.getString("author");
				
				Book book = new Book();
				book.setId(idFromDB);
				book.setName(nameFromDB);
				book.setAuthor(authorFromDB);
				
				books.add(book);
			}
			
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return books;
	}
	
	
	public ArrayList<Book> getBooksByAuthor(String keyword){
		Connection con = connect();
		ArrayList<Book> books = new ArrayList<Book>();
		
		try {
			String query = "SELECT * FROM books WHERE author LIKE '%" + keyword + "%'";
			Statement st = con.createStatement();
		
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				int idFromDB = rs.getInt("id");
				String nameFromDB = rs.getString("name");
				String authorFromDB = rs.getString("author");
				
				Book book = new Book();
				book.setId(idFromDB);
				book.setName(nameFromDB);
				book.setAuthor(authorFromDB);
				
				books.add(book);
			}
			
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return books;
	}
	
	
	public void addBook(String name, String author) {
		Connection con = connect();
		try {
			String query = "INSERT INTO books (name, author) VALUES (?, ?)";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, name);
			st.setString(2, author);
			
			st.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modifyBook(int id, String name, String author) {
		Connection con = connect();
		try {
			String query = "UPDATE books SET name=?, author=? WHERE id=?";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, name);
			st.setString(2, author);
			st.setInt(3, id);
			
			st.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteBook(int id) {
		Connection con = connect();
		try {
			String query = "DELETE FROM books  WHERE id=?";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, id);
			
			st.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
