package app.domain.model;

import java.sql.Date;

public class Invoice {
	private long id;
	private Patient patientName;
	private User doctors;
	private String companyName;
    private int policyNumber;
    private String status;
	private int validity;
    private Date date;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Patient getPatientName() {
		return patientName;
	}
	public void setPatientName(Patient patientName) {
		this.patientName = patientName;
	}
	public User getDoctors() {
		return doctors;
	}
	public void setDoctors(User doctors) {
		this.doctors = doctors;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}
	public int getValidity() {
		return validity;
	}
	public void setValidity(int validity) {
		this.validity = validity;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
    
    
    
    
	
    
    
    

	

	
	

}
