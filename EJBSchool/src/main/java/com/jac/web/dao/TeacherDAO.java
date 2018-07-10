package com.jac.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jac.web.model.Teacher;

public class TeacherDAO {

	private final static String HOSTNAME = "den1.mysql5.gear.host:3306";
	private final static String DBNAME = "ejbs";
	private final static String USERNAME = "ejbs";
	private final static String PASSWORD = "tp%ipd12";

	private Connection conn;

	public TeacherDAO() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		conn = DriverManager.getConnection("jdbc:mysql://" + HOSTNAME + "/" + DBNAME, USERNAME, PASSWORD);

	}

	public Teacher getTeacherByUsername(String username) throws SQLException{
		String sql = "SELECT * FROM teachers WHERE userName = ?";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, username);

		ResultSet result = stmt.executeQuery();
		if (result.next()) {
			Teacher teacher = new Teacher(result.getInt("teacherId"), result.getString("username"),
					result.getString("password"), result.getString("firstName"), result.getString("lastName"),
					result.getString("city"), result.getString("postalCode"));

			return teacher;

		} else {

			return null;

		}
	}
}
