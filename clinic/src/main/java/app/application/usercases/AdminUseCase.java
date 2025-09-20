package app.application.usercases;

import app.domain.model.Appointment;
import app.domain.model.EmergencyContact;
import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.services.CreateAdministrative;
import app.domain.services.CreateInvoice;
import app.domain.services.CreateMedicalAppointment;
import app.domain.services.CreatePatient;

public class AdminUseCase {
	
	private CreateInvoice createInvoice;
	private CreatePatient createPatient;
	private CreateMedicalAppointment createMedicalAppointment;
	private CreateAdministrative updatePatient;
	private CreateAdministrative createEmergencycontact;
	
	public void createPatient(Patient patient) throws Exception {
        createPatient.create(patient);
    }
	
	public void updatePatient(Patient patient) throws Exception {
		updatePatient.UpdatePatient(patient);
    }

   
    public void createInvoice(Invoice invoice) throws Exception {
        createInvoice.createinvoice(invoice);
    }

    public void CreateMedicalAppointmen(Appointment appointment) throws Exception {
    	createMedicalAppointment.createMedicalAppointment(appointment);
       
    	
    }
    
    public void createEmergencycontact(EmergencyContact contact) throws Exception {
    	createEmergencycontact.createEmergencycontact(contact);
    }
    
	
	

}

