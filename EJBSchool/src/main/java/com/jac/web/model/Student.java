package com.jac.web.model;

public class Student {
	private int studentId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String city;
	private String postalCode;
	
	// Construction without parameters
	public Student() {
		
	}
	
	// Construction with parameters
		public Student(int studentId, String userName, String firstName, String lastName, String city,
				String postalCode) {
			super();
			this.studentId = studentId;
			this.userName = userName;
			this.firstName = firstName;
			this.lastName = lastName;
			this.city = city;
			this.postalCode = postalCode;
		}
		
	// Construction with parameters
	public Student(int studentId, String userName, String password, String firstName, String lastName, String city,
			String postalCode) {
		super();
		this.studentId = studentId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.postalCode = postalCode;
	}
	
	// Getters & Setters
	public int getStudentId() {
		return studentId;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	/**
	 *  Get full name by combining first and last name
	 * @return full name
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	
}
