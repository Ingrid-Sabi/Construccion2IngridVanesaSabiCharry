package app.application.usercases;

import java.util.List;

import app.domain.model.ClinicalOrder;
import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;
import app.domain.services.CreateDoctor;

public class DoctorUseCase {
	
	private CreateDoctor createDoctor;
	private ClinicalOrder clinicalOrder;
	private ClinicalRecord clinicalRecord;
	private ClinicalOrder create;
	
	
	public void createClinicalOrder(ClinicalOrder clinicalOrder) throws Exception {
		create.create(clinicalOrder);
	}
	
	public List<ClinicalOrder> searchOrders(Patient patient) throws Exception{
		return SearchClinicalOrder.search(patient);
	}
	
	public void createClinicalRecord(ClinicalRecord clinicalRecord) throws Exception {
		Object createClinicalRecord;
		createClinicalRecord.create(clinicalRecord);
	}
	
	public void updateClinicalRecord(ClinicalRecord clinicalRecord) throws Exception{
        updateClinicalRecord.update(clinicalRecord);
    }

}
