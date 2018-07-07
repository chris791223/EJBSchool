package com.jac.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
}
