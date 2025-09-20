package app.domain.ports;

import app.domain.model.MedicalOrder;

public interface MedicalOrderPort {

	public default void save(MedicalOrder order) {
		// TODO Auto-generated method stub
		
	}

	public MedicalOrder findById(String orderId);

}