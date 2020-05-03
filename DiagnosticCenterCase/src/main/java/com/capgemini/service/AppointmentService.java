package com.capgemini.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.AppointmentDao;
import com.capgemini.exception.AppointmentNotFoundException;
import com.capgemini.exception.AppointmentNotRemovedException;
import com.capgemini.exception.DiagnosticCenterNotRemovedException;
import com.capgemini.exception.NullException;
import com.capgemini.exception.NullValueException;
import com.capgemini.exception.WrongValueException;
import com.capgemini.model.Appointment;
import com.capgemini.model.DiagnosticCenter;

@Service
public class AppointmentService {
	@Autowired
	AppointmentDao appointmentDao;

	public String saveAppointment(Appointment appointment) {
		try {
			if (appointment.getDatetime().equals(null) || appointment.getCenter().equals(null)||appointment.getTest().equals(null)|| appointment.getUsers().equals(null))
				throw new NullValueException("Any field in appointment cannot be null");
			else
				appointmentDao.save(appointment);
			return "Appointment saved";
		} catch (NullValueException ex) {
			System.out.println(ex);
		}
		return null;
	}

	public String removeAppointment(Appointment appointment) {
		if(appointmentDao.findById(appointment.getAppointmentId()).isPresent())
		{
			appointmentDao.delete(appointment);
		return "Appointment deleted";
		}
		else
		return "Appointment does not exist";
	}

	public Optional<Appointment> findById(long appointmentId) {
		Optional<Appointment> appointment = appointmentDao.findById(appointmentId);
		try {
			if (appointment != null)
				return appointment;
			else
				throw new AppointmentNotFoundException("Oops!! Appointment not found!");
		} catch (AppointmentNotFoundException ex) {
			System.out.println(ex);
		}
		return null;
	}
	public String updateAppointment(Appointment appointment) {
		if (appointment != null) {
			Optional<Appointment> findById = appointmentDao.findById(appointment.getAppointmentId());
			if (findById.isPresent()) {
				appointmentDao.save(appointment);
				return "AppointmentList updated";
			} else {
				throw new NullException("Diagnostic Center Is not Updated!!!!!!!");
			}
		} else {
			throw new WrongValueException("Details are Incorrect!!!!!!!!!!");
		}
	}
	public String deleteAppointment(long appointmentId) {
		// TODO Auto-generated method stub
		if (appointmentId != 0) {
			Optional<Appointment> findById = appointmentDao.findById(appointmentId);
			if (findById.isPresent()) {
				appointmentDao.deleteById(appointmentId);
				return "Appointment Remove";
			} else {
				throw new AppointmentNotRemovedException("Appointment is Not Removed ");
			}
		}

		else {
			throw new WrongValueException("Appointment Incorrect!!!!!!");
		}
	}


}
