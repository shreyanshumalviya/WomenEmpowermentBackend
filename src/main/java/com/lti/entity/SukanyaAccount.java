package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
public class SukanyaAccount {

	@Id
	@SequenceGenerator(name = "sukanya_seq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "sukanya_seq", strategy = GenerationType.SEQUENCE)
	int accountId;

	String beneficiaryName;
	LocalDate dob;
	String adharNo;
	LocalDate registrationDate;
	boolean verified;

	@OneToOne(mappedBy = "sukanyaAccount")
	SukanyaDoc sukanyaDoc;

	@ManyToOne
	@JoinColumn(name = "userId")
	User user;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public SukanyaDoc getSukanyaDoc() {
		return sukanyaDoc;
	}

	public void setSukanyaDoc(SukanyaDoc sukanyaDoc) {
		this.sukanyaDoc = sukanyaDoc;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
