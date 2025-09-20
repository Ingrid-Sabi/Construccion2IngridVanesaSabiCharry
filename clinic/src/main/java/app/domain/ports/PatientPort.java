package app.domain.ports;

import app.domain.model.NurseVisit;
import app.domain.model.Patient;

public interface PatientPort {
	
	    public Patient findByDocument(Object patient) throws Exception;	    	    
	    public Patient findByUserName(Patient patient) throws Exception;
	    public void save(Patient patient) throws Exception;
	    public Patient findById(String patientName);
		public void save(NurseVisit visit);
		public void update(Patient existing);

		

}
