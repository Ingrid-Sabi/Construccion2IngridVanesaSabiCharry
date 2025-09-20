package app.domain.model;

import java.sql.Date;
import java.util.List;

public class ClinicalOrder {
	private long id; 
	private String orderNumber;
	private Patient document;
	private Date date;
	private User doctors;

	

	private List<Item> items;
	
public void estoSeBorraPorqueEsUnEjemplo() {
	items.add(new MedicalItem());
	items.add(new ProcedureItem());}

public Object getDocument() {
	// TODO Auto-generated method stub
	return null;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getOrderNumber() {
	return orderNumber;
}

public void setOrderNumber(String orderNumbre) {
	this.orderNumber = orderNumbre;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public User getDoctors() {
	return doctors;
}

public void setDoctors(User doctors) {
	this.doctors = doctors;
}

public List<Item> getItems() {
	return items;
}

public void setItems(List<Item> items) {
	this.items = items;
}

public void setDocument(Patient document) {
	this.document = document;
}

}
