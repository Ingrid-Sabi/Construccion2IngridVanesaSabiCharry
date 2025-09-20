package app.domain.services;

import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.emuns.Role;
import app.domain.ports.ClinicalOrderPort;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;

public class CreateClinicalOrder {
	
	private ClinicalOrderPort clinicalOrderPort;
	private PatientPort patientPort;
	private UserPort userPort;
	
	public void create(ClinicalOrder clinicalOrder) throws Exception {
		
		
		Patient patient = patientPort.findByDocument(clinicalOrder.getDocument());
		if (patient == null) {
			throw new Exception("La orden clínica debe estar asociada a un paciente válido");
		}
		
		
		User doctor = userPort.findByDocument(clinicalOrder.getDoctors());
		if (doctor == null || !doctor.getRole().equals(Role.DOCTORS)) {
		    throw new Exception("La orden clínica debe estar registrada por un doctor válido");
		}
		
		
		if (clinicalOrderPort.findByOrderNumber(clinicalOrder.getOrderNumber()) != null) {
			throw new Exception("Ya existe una orden clínica registrada con ese número");
		}
		
		
		clinicalOrderPort.save(clinicalOrder);
	}
}
