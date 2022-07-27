package com.lti.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_ngo")
public class Ngo {

	@Id
	@SequenceGenerator(name = "ngo_seq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "ngo_seq", strategy = GenerationType.SEQUENCE)
	int ngoId;

	String name;
	String email;
	String password;
	String address;
	String description;
	String contact;
	boolean isVerified;

	@OneToMany(mappedBy = "ngo")
	List<Courses> course;

	@OneToOne(mappedBy = "ngo")
	NgoDocuments ngoDoc;

	@OneToMany(mappedBy = "ngo")
	List<Accomodation> accomodations;

	public int getNgoId() {
		return ngoId;
	}

	public void setNgoId(int ngoId) {
		this.ngoId = ngoId;
	}

	public String getNgoName() {
		return name;
	}

	public void setNgoName(String ngoName) {
		this.name = ngoName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNgoContact() {
		return contact;
	}

	public void setNgoContact(String ngoContact) {
		this.contact = ngoContact;
	}

	public List<Accomodation> getAccomodations() {
		return accomodations;
	}

	public void setAccomodations(List<Accomodation> accomodations) {
		this.accomodations = accomodations;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public NgoDocuments getNgoDoc() {
		return ngoDoc;
	}

	public void setNgoDoc(NgoDocuments ngoDoc) {
		this.ngoDoc = ngoDoc;
	}

	public List<Courses> getCourse() {
		return course;
	}

	public void setCourse(List<Courses> course) {
		this.course = course;
	}

	public List<Accomodation> getAccomodation() {
		return accomodations;
	}

	public void setAccomodation(List<Accomodation> accomodation) {
		this.accomodations = accomodation;
	}

	
}
