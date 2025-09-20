package app.domain.services;

import app.domain.model.Patient;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;

public class CreatePatient {

	private PatientPort patientPort;
	private UserPort userPort;

	public void create(Patient patient) throws Exception {

		if (patientPort.findByDocument(patient) != null) {
			throw new Exception("Ya existe una persona registrada con esa cédula");
		}

		if (patientPort.findByUserName(patient) != null) {
			throw new Exception("Ya existe una persona registrada con ese nombre de usuario");
		}

		patientPort.save(patient);
	}

	public UserPort getUserPort() {
		return userPort;
	}

	public void setUserPort(UserPort userPort) {
		this.userPort = userPort;
	}
}
