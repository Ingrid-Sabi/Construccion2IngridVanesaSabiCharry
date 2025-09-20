package app.application.usercases;

import java.util.List;
import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;
import app.domain.services.CreateNurse;


public class NurseUseCase {
	
	private CreateNurse createNurse;
	
	

	public List<ClinicalOrder> searchClinicalOrder(Patient patient) throws Exception{
		
		return searchClinicalOrderByPatient.search(patient);
		}

	public void searchPatient(Patient patient) throws Exception{
	    searchPatientByDocument.search(patient);
	    }

	public void registerVisit(Patient patient) throws Exception{
	     segisterVisit.registerVisit(patient);
	    }

}
