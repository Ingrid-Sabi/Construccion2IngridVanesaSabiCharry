package app.domain.services;

import app.domain.model.NurseVisit;
import app.domain.model.Patient;
import app.domain.model.MedicalOrder;
import app.domain.ports.PatientPort;
import app.domain.ports.NurseVisitPort;
import app.domain.ports.MedicalOrderPort;

public class CreateNurse {

    private NurseVisitPort nurseVisitPort;
    private PatientPort patientPort;
    private MedicalOrderPort medicalOrderPort;

    // METHODO 1: RegisterVisit
    public void RegisterVisit(NurseVisit visit) throws Exception {
        if (visit == null) {
            throw new Exception("La visita de enfermería no puede ser nula");
        }

        if (visit.getPatientDocument() == null || ((Patient) visit.getPatientDocument()).isEmpty()) {
            throw new Exception("La visita debe estar asociada a un paciente válido");
        }

        Patient patient = patientPort.findByDocument(visit.getPatientDocument());
        if (patient == null) {
            throw new Exception("El paciente asociado a la visita no existe");
        }

        if (visit.getDate() == null) {
            throw new Exception("La visita de enfermería debe tener una fecha");
        }

        if (visit.getNotes() == null || visit.getNotes().isEmpty()) {
            throw new Exception("La visita de enfermería debe contener observaciones");
        }

        nurseVisitPort.save(visit);
    }

    // METHODO 2: SearchClinicalOrderByPatient
    public Patient SearchPatientByDocument(String document) throws Exception {
        if (document == null || document.isEmpty()) {
            throw new Exception("El documento del paciente es obligatorio");
        }

        Patient patient = patientPort.findByDocument(document);

        if (patient == null) {
            throw new Exception("No se encontró un paciente con ese documento");
        }

        return patient;
    }

    // METHODO 3: Buscar Orden Médica
    public MedicalOrder SearchCllinicalOrderByPatient(String orderId) throws Exception {
        if (orderId == null || orderId.isEmpty()) {
            throw new Exception("El ID de la orden médica es obligatorio");
        }

        MedicalOrder order = medicalOrderPort.findById(orderId);

        if (order == null) {
            throw new Exception("No se encontró una orden médica con ese ID");
        }

        return order;
    }
}
