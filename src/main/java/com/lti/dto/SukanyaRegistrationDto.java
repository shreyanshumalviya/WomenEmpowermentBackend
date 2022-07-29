package com.lti.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.lti.entity.SukanyaAccount;

public class SukanyaRegistrationDto {
//	{"firstName":"Sukanya","lastName":"Yojana","dateOfBirth":"2001-12-12","aadharNumber":"123456789098"}
	String firstName;
	String lastName;
	LocalDate dateOfBirth;
	String aadharNumber;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public SukanyaAccount toSukanyaAccount() {
		SukanyaAccount sukanyaAccount =new SukanyaAccount();
		sukanyaAccount.setAdharNo(aadharNumber);
		sukanyaAccount.setBeneficiaryName(firstName+" "+lastName);
		sukanyaAccount.setDob(dateOfBirth);
		sukanyaAccount.setRegistrationDate(new java.sql.Date(new Date().getTime()).toLocalDate());
		return sukanyaAccount;
	}
	
}
