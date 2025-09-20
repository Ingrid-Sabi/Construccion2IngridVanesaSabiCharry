package app.domain.ports;

import app.domain.model.Appointment;
import app.domain.model.Employee;

public interface EmployeePort {

	public default Object findByDocument(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	public default void update(Employee existing) {
		// TODO Auto-generated method stub
		
	}

	public default void save(Employee employee) {
		// TODO Auto-generated method stub
		
	}

}
