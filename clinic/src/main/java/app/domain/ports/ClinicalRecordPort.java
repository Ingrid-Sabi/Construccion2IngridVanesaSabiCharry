package app.domain.ports;

import app.domain.model.ClinicalRecord;
import app.domain.model.User;

public interface ClinicalRecordPort {
	
	void save(ClinicalRecord clinicalRecord);
	Object findByRecordNumber(String recordNumber);

	Object findByRecordNumber(User recordNumber);

}
