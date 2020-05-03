package com.capgemini.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq", initialValue = 1000, allocationSize = 100)
public class DiagnosticCenter {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private long centerId;
	private String centerName;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Test> listOfTest;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Appointment> aptList;

	public DiagnosticCenter() {
	}

	public DiagnosticCenter(String centerName, List<Test> listOfTest) {
		super();
		this.centerName = centerName;
		this.listOfTest = listOfTest;
	}

	public long getCenterId() {
		return centerId;
	}

	public void setCenterId(long centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public List<Test> getListOfTest() {
		return listOfTest;
	}

	public void setListOfTest(List<Test> listOfTest) {
		this.listOfTest = listOfTest;
	}

	public List<Appointment> getAptList() {
		return aptList;
	}

	public void setAptList(List<Appointment> aptList) {
		this.aptList = aptList;
	}



}
