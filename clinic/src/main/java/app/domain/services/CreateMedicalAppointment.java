package app.domain.services;

import app.domain.model.Appointment;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.emuns.Role;
import app.domain.ports.AppointmentPort;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;

public class CreateMedicalAppointment {

	private PatientPort patientPort;
	private UserPort userPort;
	private AppointmentPort appointmentPort;

	public void createMedicalAppointment(Appointment appointment) throws Exception {
		User doctor = userPort.findByDocument(appointment.getDoctor());
		if (doctor == null || !doctor.getRole().equals(Role.DOCTORS)) {
			throw new Exception("La cita debe tener un doctor");
		}

		Patient patient = patientPort.findByDocument(appointment.getPatient());

		if (patient == null) {
			throw new Exception("El paciente no se encuentra registrado");
		}
		appointment.setDoctor(doctor);
		appointment.setPatient(patient);
		appointmentPort.save(appointment);

	}
}
