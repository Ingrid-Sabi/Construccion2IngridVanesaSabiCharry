package app.domain.model;

import java.sql.Date;

public class Patient {
	private long id;
	private String name;
	private String patientDocument;
	private String doctorDocument;
	
	private Date dateBirth;
	private String address;
	private int age;
	private String mail;
	private long phone;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPatientDocument() {
		return patientDocument;
	}
	public void setPatientDocument(String patientDocument) {
		this.patientDocument = patientDocument;
	}
	public String getDoctorDocument() {
		return doctorDocument;
	}
	public void setDoctorDocument(String doctorDocument) {
		this.doctorDocument = doctorDocument;
	}
	public Date getDateBirth() {
		return dateBirth;
	}
	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	

}
