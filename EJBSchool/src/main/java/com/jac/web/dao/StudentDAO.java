package com.jac.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jac.web.model.Student;

public class StudentDAO {

	private final static String HOSTNAME = "den1.mysql5.gear.host:3306";
	private final static String DBNAME = "ejbs";
	private final static String USERNAME = "ejbs";
	private final static String PASSWORD = "tp%ipd12";

	private Connection conn;

	public StudentDAO() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		conn = DriverManager.getConnection("jdbc:mysql://" + HOSTNAME + "/" + DBNAME, USERNAME, PASSWORD);

	}

	/**
	 * Get Student info by username
	 * 
	 * @param username
	 * @return Student
	 */
	public Student getStudentByUsername(String username) throws SQLException {

		String sql = "SELECT * FROM students WHERE userName = ?";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, username);

			ResultSet result = stmt.executeQuery();
			if (result.next()) {
				Student student = new Student(
						result.getInt("studentId"), 
						result.getString("username"), 
						result.getString("password"),
						result.getString("firstName"),
						result.getString("lastName"),
						result.getString("city"),
						result.getString("postalCode"));
				
				return student;
				
			} else {
				
				return null;
				
			}
		}

	}

	/**
	 * Get Student by ID
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Student getStudentById(int id) throws SQLException {

		String sql = "SELECT * FROM students WHERE studentId = ?";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);

			ResultSet result = stmt.executeQuery();
			
			if (result.next()) {
				Student student = new Student(
						result.getInt("studentId"), 
						result.getString("username"), 
						result.getString("password"),
						result.getString("firstName"),
						result.getString("lastName"),
						result.getString("city"),
						result.getString("postalCode"));
				
				return student;
				
			} else {
				
				return null;
				
			}
		}

	}

	/**
	 * Get all students from DB
	 * @return
	 * @throws SQLException
	 */
	public List<Student> getAllStudents() throws SQLException {
		String sql = "SELECT * FROM students";
		List<Student> studentList = new ArrayList<>();

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				Student student = new Student(
						result.getInt("studentId"), 
						result.getString("username"), 
						result.getString("firstName"),
						result.getString("lastName"),
						result.getString("city"),
						result.getString("postalCode"));
				
				studentList.add(student);

			}

			return studentList;
		}
	}

	/**
	 * Add new student
	 * @param student
	 * @throws SQLException
	 */
	public void addStudent(Student student) throws SQLException {
		String sql = "INSERT INTO students (userName, password, firstName, lastName, city, postalCode) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, student.getUserName());
			stmt.setString(2, student.getPassword());
			stmt.setString(3, student.getFirstName());
			stmt.setString(4, student.getLastName());
			stmt.setString(5, student.getCity());
			stmt.setString(6, student.getPostalCode());		
			
			stmt.executeUpdate();
		}
	}

	/**
	 * Edit student 
	 * @param student
	 * @throws SQLException
	 */
	public void editStudent(Student student) throws SQLException {
		String sql = "UPDATE students SET "
				+ "userName = ?, password = ?, firstName = ?, lastName = ?, city = ?, postalCode = ? WHERE studentId = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, student.getUserName());
			stmt.setString(2, student.getPassword());
			stmt.setString(3, student.getFirstName());
			stmt.setString(4, student.getLastName());
			stmt.setString(5, student.getCity());
			stmt.setString(6, student.getPostalCode());	
			stmt.setInt(7, student.getStudentId());
			
			stmt.executeUpdate();
		}
	}

	/**
	 * Delete student
	 * @param id
	 * @throws SQLException
	 */
	public void deleteStudent(int id) throws SQLException {
		String sql = "DELETE FROM students WHERE studentId = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			
			stmt.executeUpdate();
		}
	}
}
