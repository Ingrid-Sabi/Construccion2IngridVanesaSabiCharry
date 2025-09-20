package app.domain.services;
import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.ports.PatientPort;

public class CreateInvoice {
	
	private PatientPort patientPort;
	
	public void createinvoice(Invoice invoice) throws Exception {
		
		
		if (invoice == null) {
			throw new Exception("La factura no puede ser nula");
		}
		
		if (invoice.getDate() == null) {
			throw new Exception("La fecha de la factura es obligatoria");
		}
		if (invoice.getPatientName() == null || invoice.getPatientName().isEmpty()) {
			throw new Exception("La factura debe tener un paciente asociado con nombre válido");
		}
		Patient patient = patientPort.findByDocument(invoice.getPatientName());
		if (patient == null) {
			throw new Exception("El paciente asociado a la factura no existe en el sistema");
		}
		
		
		
	}
}
