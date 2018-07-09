package com.jac.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jac.web.model.Student;

public class StudentDAO {
	private Connection con = null;
	
	public StudentDAO() {
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
	}
	
	public Student getStudent(String username) {
		Student s1 = null;
		try{
			String query = "select * from students where username = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				s1 = new Student();
				int studentID = rs.getInt("studentID");
				String nameFromDB = rs.getString("username");
				String passwordFromDB = rs.getString("password");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String city = rs.getString("city");
				String postalCode = rs.getString("postalCode");
				
				s1.setStudentID(studentID);
				s1.setUsername(nameFromDB);
				s1.setPassword(passwordFromDB);
				s1.setFirstName(firstName);
				s1.setLastName(lastName);
				s1.setCity(city);
				s1.setPostalCode(postalCode);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return s1;
	}
}
