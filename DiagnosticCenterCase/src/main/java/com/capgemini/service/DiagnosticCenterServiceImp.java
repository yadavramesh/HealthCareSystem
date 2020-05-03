package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.dao.DiagnosticCenterDao;
import com.capgemini.exception.DiagnosticCenterNotAdded;
import com.capgemini.exception.DiagnosticCenterNotRemovedException;
import com.capgemini.exception.InvalidException;
import com.capgemini.exception.NullException;
import com.capgemini.exception.WrongValueException;
import com.capgemini.model.DiagnosticCenter;

@Service
public class DiagnosticCenterServiceImp implements DiagnosticCenterService {
	@Autowired
	DiagnosticCenterDao diagnosticCenterDoa;

	@Override
	public DiagnosticCenter saveDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		// TODO Auto-generated method stub
		Optional<DiagnosticCenter> findById = diagnosticCenterDoa.findById(diagnosticCenter.getCenterId());
		if (!findById.isPresent()) {
			diagnosticCenterDoa.save(diagnosticCenter);
			return diagnosticCenter;
		} else {
			throw new DiagnosticCenterNotAdded("Diagnostic Center Already Added");
		}

	}

	@Override
	public String deleteDiagnosticCenter(long centerId) {
		// TODO Auto-generated method stub
		if (centerId != 0) {
			Optional<DiagnosticCenter> findById = diagnosticCenterDoa.findById(centerId);
			if (findById.isPresent()) {
				diagnosticCenterDoa.deleteById(centerId);
				return "DiagnosticCenter  Remove";
			} else {
				throw new DiagnosticCenterNotRemovedException("Diagnostic Center is Not Removed ");
			}
		}

		else {
			throw new WrongValueException("Center Incorrect!!!!!!");
		}
	}

	@Override
	public String updateDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		if (diagnosticCenter != null) {
			Optional<DiagnosticCenter> findById = diagnosticCenterDoa.findById(diagnosticCenter.getCenterId());
			if (findById.isPresent()) {
				diagnosticCenterDoa.save(diagnosticCenter);
				return "DiagnosticCenter updated";
			} else {
				throw new NullException("Diagnostic Center Is not Updated!!!!!!!");
			}
		} else {
			throw new WrongValueException("Details are Incorrect!!!!!!!!!!");
		}
	}

	@Override
	public Optional<DiagnosticCenter> findById(long centerId) {
		if (centerId != 0) {
			Optional<DiagnosticCenter> findById = diagnosticCenterDoa.findById(centerId);
			return findById;
		} else {
			throw new InvalidException("CenterId is invalid");
		}
	}

	@Override
	public List<DiagnosticCenter> getAll() {
		// TODO Auto-generated method stub
		List<DiagnosticCenter> dList = diagnosticCenterDoa.findAll();
		if (dList == null) {
			throw new NullException("Diagnostic Center List is Empty !!!!!!");
		} else {
			return dList;
		}
	}

}
