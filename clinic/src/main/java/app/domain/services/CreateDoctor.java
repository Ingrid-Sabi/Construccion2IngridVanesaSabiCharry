package app.domain.services;

import app.domain.model.ClinicalRecord;
import app.domain.model.MedicalRecord;
import app.domain.model.MedicalOrder;
import app.domain.model.Patient;
import app.domain.ports.ClinicalRecordPort;
import app.domain.ports.MedicalRecordPort;
import app.domain.ports.MedicalOrderPort;
import app.domain.ports.PatientPort;

public class CreateDoctor {

    private ClinicalRecordPort clinicalRecordPort;
    private PatientPort patientPort;
    private MedicalRecordPort medicalRecordPort;
    private MedicalOrderPort medicalOrderPort;

    // SearchClinicalOrder
    public ClinicalRecord searchClinicalOrder(String recordNumber) throws Exception {
        if (recordNumber == null || recordNumber.isEmpty()) {
            throw new Exception("El número de la historia clínica es obligatorio");
        }

        ClinicalRecord clinicalRecord = (ClinicalRecord) clinicalRecordPort.findByRecordNumber(recordNumber);

        if (clinicalRecord == null) {
            throw new Exception("No se encontró una historia clínica con ese número");
        }

        return clinicalRecord;
    }

    // createClinicalRecord
    public void CreateClinicalRecord(MedicalRecord medicalRecord) throws Exception {
        if (medicalRecord == null) {
            throw new Exception("El registro médico no puede ser nulo");
        }

        if (medicalRecord.getPatientDocument() == null || medicalRecord.getPatientDocument().isEmpty()) {
            throw new Exception("El registro médico debe tener un documento de paciente");
        }

        Patient patient = patientPort.findByDocument(medicalRecord.getPatientDocument());
        if (patient == null) {
            throw new Exception("El paciente asociado al registro médico no existe");
        }

        if (medicalRecord.getDate() == null) {
            throw new Exception("El registro médico debe tener una fecha");
        }

        if (medicalRecord.getDiagnosis() == null || medicalRecord.getDiagnosis().isEmpty()) {
            throw new Exception("El diagnóstico es obligatorio");
        }

        medicalRecordPort.save(medicalRecord);
    }

    // updateClinicalRecord
    public void updateClinicalRecord(MedicalRecord medicalRecord) throws Exception {
        if (medicalRecord == null) {
            throw new Exception("El registro médico no puede ser nulo");
        }

        if (medicalRecord.getRecordId() == null || medicalRecord.getRecordId().isEmpty()) {
            throw new Exception("El registro médico debe tener un ID válido");
        }

        MedicalRecord existing = medicalRecordPort.findById(medicalRecord.getRecordId());
        if (existing == null) {
            throw new Exception("No existe un registro médico con ese ID");
        }

        // Actualiza de los campos
        existing.setDiagnosis(medicalRecord.getDiagnosis());
        existing.setTreatment(medicalRecord.getTreatment());
        existing.setNotes(medicalRecord.getNotes());

        medicalRecordPort.update(existing);
    }

    // Create Order 
    public void createOrder(MedicalOrder order) throws Exception {
        if (order == null) {
            throw new Exception("La orden médica no puede ser nula");
        }

        if (order.getPatientDocument() == null || ((Patient) order.getPatientDocument()).isEmpty()) {
            throw new Exception("La orden debe estar asociada a un paciente");
        }

        Patient patient = patientPort.findByDocument(order.getPatientDocument());
        if (patient == null) {
            throw new Exception("El paciente asociado a la orden no existe");
        }

        if ((order.getMedications() == null || order.getMedications().isEmpty()) &&
            (order.getProcedures() == null || ((Patient) order.getProcedures()).isEmpty()) &&
            (order.getDiagnosticAids() == null || ((Patient) order.getDiagnosticAids()).isEmpty())) {
            throw new Exception("La orden debe contener al menos un ítem (medicamento, procedimiento o ayuda diagnóstica)");
        }

        medicalOrderPort.save(order);
    }
}
