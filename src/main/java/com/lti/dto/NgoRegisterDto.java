package com.lti.dto;

import com.lti.entity.Ngo;

public class NgoRegisterDto {
	int ngoId;
	String name;
	String email;
	String password;
	String address;
	String description;
	String contact;
	Boolean isVerified;

	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

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

	public Ngo toNgo() {
		Ngo ngo = new Ngo();
		ngo.setNgoId(ngoId);
		ngo.setName(name);
		ngo.setEmail(email);
		ngo.setPassword(password);
		ngo.setAddress(address);
		ngo.setContact(contact);
		ngo.setDescription(description);
		ngo.setVerified(isVerified);
		return ngo;
	}
}
