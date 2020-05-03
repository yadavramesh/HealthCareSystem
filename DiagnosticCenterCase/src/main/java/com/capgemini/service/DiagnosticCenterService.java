package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.model.DiagnosticCenter;

public interface DiagnosticCenterService {
	
	public DiagnosticCenter saveDiagnosticCenter(DiagnosticCenter diagnosticCenter);
	public String deleteDiagnosticCenter(long centerId);
	public String updateDiagnosticCenter(DiagnosticCenter diagnosticCenter);
	public Optional<DiagnosticCenter> findById(long centerId);
	public List<DiagnosticCenter> getAll();

}
