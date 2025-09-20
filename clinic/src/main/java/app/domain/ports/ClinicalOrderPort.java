package app.domain.ports;

import app.domain.model.ClinicalOrder;

public interface ClinicalOrderPort {


	public Object findByOrderNumber(Object orderNumber) throws Exception;
	public void save(ClinicalOrder clinicalOrder) throws Exception;

}

