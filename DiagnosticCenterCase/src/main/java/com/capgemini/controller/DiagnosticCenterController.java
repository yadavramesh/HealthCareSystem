package com.capgemini.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.exception.NullException;
import com.capgemini.exception.WrongValueException;
import com.capgemini.model.DiagnosticCenter;
import com.capgemini.service.DiagnosticCenterService;

@RestController
@RequestMapping("/DiagnosticCenter")
@CrossOrigin("http://localhost:4200")
public class DiagnosticCenterController {
	@Autowired
	DiagnosticCenterService service;
	Logger logger = LoggerFactory.getLogger(DiagnosticCenterController.class);

	@GetMapping("/getAllCenter")
	public ResponseEntity<List<DiagnosticCenter>> getAll() {
		try {
			List<DiagnosticCenter> list = service.getAll();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			throw new NullException(e.getMessage());
		}
	}

	@PostMapping("/add")
	public ResponseEntity<DiagnosticCenter> addDiagnosticCenter(@RequestBody DiagnosticCenter diagnosticCenter) {
		try {
			service.saveDiagnosticCenter(diagnosticCenter);
			return new ResponseEntity<>(diagnosticCenter, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			throw new WrongValueException(e.getMessage());
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteDiagnosticCenter(@PathVariable("centerId") long centerId) {
		try {
			service.deleteDiagnosticCenter(centerId);
			return new ResponseEntity<String>("Deleted", HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			throw new NullException(e.getMessage());
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		try {
			service.updateDiagnosticCenter(diagnosticCenter);
			return new ResponseEntity<String>("Updated", HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			throw new WrongValueException(e.getMessage());
		}
	}

}
