package com.lti.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	@JsonBackReference
	List<Course> course;

	@OneToOne(mappedBy = "ngo")
	@JsonBackReference
	NgoDocuments ngoDoc;

	@OneToMany(mappedBy = "ngo")
	@JsonBackReference
	List<Accomodation> accomodation;

	public int getNgoId() {
		return ngoId;
	}

	public void setNgoId(int ngoId) {
		this.ngoId = ngoId;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	public NgoDocuments getNgoDoc() {
		return ngoDoc;
	}

	public void setNgoDoc(NgoDocuments ngoDoc) {
		this.ngoDoc = ngoDoc;
	}

	public List<Accomodation> getAccomodation() {
		return accomodation;
	}

	public void setAccomodation(List<Accomodation> accomodations) {
		this.accomodation = accomodations;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

}