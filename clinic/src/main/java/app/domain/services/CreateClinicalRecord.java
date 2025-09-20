package app.domain.services;

import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.emuns.Role;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;
import app.domain.ports.ClinicalRecordPort;

public class CreateClinicalRecord {
	
	private UserPort userPort;
	private PatientPort patientPort;
	private ClinicalRecordPort clinicalRecordPort;
	
	public void create(ClinicalRecord clinicalRecord) throws Exception {
		
	
		
		Patient patient = patientPort.findByDocument(clinicalRecord.getPatient().getPatientDocument());
		if (patient == null) {
			throw new Exception("La historia clínica debe estar asociada a un paciente válido");
		}
		
		
		
		User doctor = userPort.findByDocument(clinicalRecord.getDoctors());
		if (doctor == null || !doctor.getRole().equals(Role.DOCTORS)) {
			throw new Exception("La historia clínica se debe registrar por un doctor válido");
		}
		
			
		clinicalRecordPort.save(clinicalRecord);
	}
}