package com.capgemini.model;
import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long appointmentId;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "testId")
	private Test test;
	private Date datetime;
	private boolean approved=false;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "userId", nullable = false)
	private Users users;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "centerId")
	private DiagnosticCenter center;


	public Appointment(long appointmentId, Test test, Date datetime, boolean approved, Users users,
			DiagnosticCenter center) {
		super();
		this.appointmentId = appointmentId;
		this.test = test;
		this.datetime = datetime;
		this.approved = approved;
		this.users = users;
		this.center = center;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public DiagnosticCenter getCenter() {
		return center;
	}

	public void setCenter(DiagnosticCenter center) {
		this.center = center;
	}

}
