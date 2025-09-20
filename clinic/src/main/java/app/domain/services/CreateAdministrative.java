package app.domain.services;

import app.domain.model.Patient;
import app.domain.model.Appointment;
import app.domain.model.Invoice;
import app.domain.model.EmergencyContact;
import app.domain.ports.PatientPort;
import app.domain.ports.AppointmentPort;
import app.domain.ports.InvoicePort;
import app.domain.ports.EmergencyContactPort;

public class CreateAdministrative {

    private PatientPort patientPort;
    private AppointmentPort appointmentPort;
    private InvoicePort invoicePort;
    private EmergencyContactPort emergencyContactPort;

    // METHODO 1: createPatient
    public void createPatient(Patient patient) throws Exception {
        if (patient == null) {
            throw new Exception("El paciente no puede ser nulo");
        }

        if (patientPort.findByDocument(patient) != null) {
            throw new Exception("Ya existe un paciente registrado con ese documento");
        }

        if (patient.getName() == null ||patient.getName().isEmpty()) {
            throw new Exception("El nombre de usuario es obligatorio");
        }

        if (patient.getAge() <= 0) {
            throw new Exception("La edad debe ser mayor a 0");
        }

        if (patient.getMail() == null || patient.getMail().isEmpty() || !patient.getMail().contains("@")) {
            throw new Exception("El correo electrónico es obligatorio y debe ser válido");
        }
        

       
        patientPort.save(patient) ;
    }

    // METHODO 2: updatePatient
    public void UpdatePatient(Patient patient) throws Exception {
        if (patient == null) {
            throw new Exception("El paciente no puede ser nulo");
        }

        Patient existing = patientPort.findByDocument(patient);
        if (existing == null) {
            throw new Exception("No existe un paciente con ese documento");
        }

        existing.setName(patient.getName());
        existing.setMail(patient.getMail());
        existing.setPhone(patient.getPhone());
        existing.setAge(patient.getAge());

        patientPort.update(existing);
    }

    // MÉTODO 3: Crear Cita
    public void crearCita(Appointment appointment) throws Exception {
        if (appointment == null) {
            throw new Exception("La cita no puede ser nula");
        } 

        if (appointment.getDate() == null) {
            throw new Exception("La cita debe tener una fecha");
        }

        if (appointment.getPatientDocument() == null || ((Patient) appointment.getPatientDocument()).isEmpty()) {
            throw new Exception("La cita debe estar asociada a un paciente válido");
        }

        Patient patient = patientPort.findByDocument(appointment.getPatientDocument());
        if (patient == null) {
            throw new Exception("El paciente asociado a la cita no existe");
        }

        appointmentPort.save(appointment);
    }

    // MÉTODO 4: Crear Factura
    public void crearFactura(Invoice invoice) throws Exception {
        if (invoice == null) {
            throw new Exception("La factura no puede ser nula");
        }

        if (invoice.getDate() == null) {
            throw new Exception("La factura debe tener una fecha");
        }

        if (invoice.getPatientName() == null || invoice.getPatientName().isEmpty()) {
            throw new Exception("La factura debe tener un paciente asociado");
        }

       
    }

    // MÉTODO 5: createEmergencycontact
    public void createEmergencycontact(EmergencyContact contact) throws Exception {
        if (contact == null) {
            throw new Exception("El contacto de emergencia no puede ser nulo");
        }

        if (contact.getPatientDocument() == null || ((Patient) contact.getPatientDocument()).isEmpty()) {
            throw new Exception("El contacto de emergencia debe estar asociado a un paciente");
        }

        Patient patient = patientPort.findByDocument(contact.getPatientDocument());
        if (patient == null) {
            throw new Exception("El paciente asociado al contacto de emergencia no existe");
        }

        if (contact.getName() == null || contact.getName().isEmpty()) {
            throw new Exception("El nombre del contacto de emergencia es obligatorio");
        }

        if (contact.getPhone() == null || ((String) contact.getPhone()).length() < 7) {
            throw new Exception("El teléfono del contacto de emergencia debe tener al menos 7 dígitos");
        }

        emergencyContactPort.save(contact);
    }
}
//hola soy juan
//larry