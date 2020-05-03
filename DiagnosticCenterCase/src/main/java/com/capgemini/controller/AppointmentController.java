package com.capgemini.controller;

import java.util.List;
import java.util.Optional;

import com.capgemini.model.DiagnosticCenter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.exception.NullException;
import com.capgemini.model.Appointment;
import com.capgemini.service.AppointmentService;
import com.capgemini.service.DiagnosticCenterService;

@RestController
@RequestMapping("/Controller")
@CrossOrigin("http://localhost:4200")
public class AppointmentController {
	@Autowired
	AppointmentService appointmentService;
	@Autowired
	DiagnosticCenterService diagnosticCenterService;
	Logger logger = LoggerFactory.getLogger(DiagnosticCenterController.class);

	@PostMapping("/MakeAppointment")
	public ResponseEntity<?> makeAppointment(@RequestBody Appointment appointment) {
		try {
			appointmentService.saveAppointment(appointment);
			return new ResponseEntity<String>("Wait for confirmation!", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			throw new NullException(e.getMessage());
		}
	}

	@GetMapping("/ApproveAppointment/{id}")
	public ResponseEntity<List<Appointment>> approveAppointment(@PathVariable("id") int centerId) {
		try {
			Optional<DiagnosticCenter> ds = diagnosticCenterService.findById(centerId);
			if (ds.isPresent())
				return new ResponseEntity<>(ds.get().getAptList(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			throw new NullException(e.getMessage());
		}
		return null;
	}

	@PostMapping("/Approved")
	public ResponseEntity<?> approved(@RequestBody Appointment appointment) {
		try {
			appointment.setApproved(true);
			appointmentService.updateAppointment(appointment);
			return new ResponseEntity<String>("Appointment Approved!", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			throw new NullException(e.getMessage());
		}
	}

	@PostMapping("/NotApproved")
	public ResponseEntity<?> notApproved(@RequestBody Appointment appointment) {
		try {
			appointment.setApproved(false);
			appointmentService.deleteAppointment(appointment.getAppointmentId());
			return new ResponseEntity<String>("Appointment NOT Approved!", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			throw new NullException(e.getMessage());
		}
	}

	@GetMapping("/AppointmentStatus/{id}")
	public ResponseEntity<String> appointmentStatus(@PathVariable("id") long appointmentId) {
		try {
			if (appointmentService.findById(appointmentId).isPresent())
				return new ResponseEntity<>("Your appointment is confirmed", HttpStatus.OK);
			else
				return new ResponseEntity<>("Appointment NOT Approved!", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			throw new NullException(e.getMessage());
		}
	}
}
