package com.capgemini.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity

public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userseq")
	@SequenceGenerator(sequenceName = "userseq", allocationSize = 1, name = "userseq")
	private long userId;
	@OneToOne(mappedBy = "users")
	@JoinColumn(name="appointmentId")
	private Appointment appointment;
	private String userPasword;
	private String userName;
	private String contactNo;
	private String userRole;
	private String email;
	private int age;
	private String gender;

	public Users() {
	}

	public Users(long userId, String userPasword, String userName, String contactNo, String userRole, String email,
			int age, String gender) {
		super();
		this.userId = userId;
		this.userPasword = userPasword;
		this.userName = userName;
		this.contactNo = contactNo;
		this.userRole = userRole;
		this.email = email;
		this.age = age;
		this.gender = gender;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserPasword() {
		return userPasword;
	}

	public void setUserPasword(String userPasword) {
		this.userPasword = userPasword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userPasword=" + userPasword + ", userName=" + userName + ", contactNo="
				+ contactNo + ", userRole=" + userRole + ", email=" + email + ", age=" + age + ", gender=" + gender
				+ "]";
	}

}
