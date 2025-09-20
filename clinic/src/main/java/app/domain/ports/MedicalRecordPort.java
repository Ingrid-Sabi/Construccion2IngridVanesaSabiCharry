package app.domain.ports;

import app.domain.model.MedicalRecord;
import app.domain.model.Patient;

public interface MedicalRecordPort {

	public default void save(MedicalRecord medicalRecord) {
		// TODO Auto-generated method stub
		
	}

	public default MedicalRecord findById(Patient recordId) {
		// TODO Auto-generated method stub
		return null;
	}

	public default void update(MedicalRecord existing) {
		// TODO Auto-generated method stub
		
	}

}