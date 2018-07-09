package com.jac.web.model;

public class Teacher {
	private int teacherId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String city;
	private String postalCode;

	// Construction without parameters
	public Teacher() {

	}

	// Construction with parameters
	public Teacher(int teacherId, String userName, String firstName, String lastName, String city, String postalCode) {
		super();
		this.teacherId = teacherId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.postalCode = postalCode;
	}

	// Construction with parameters
	public Teacher(int teacherId, String userName, String password, String firstName, String lastName, String city,
			String postalCode) {
		super();
		this.teacherId = teacherId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.postalCode = postalCode;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
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

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", userName=" + userName + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", city=" + city + ", postalCode=" + postalCode + "]";
	}

}
