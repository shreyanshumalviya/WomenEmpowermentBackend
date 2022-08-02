package com.lti.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tbl_user")
public class User {

	@Id
	@SequenceGenerator(name = "user_seq", initialValue = 1000001, allocationSize = 1)
	@GeneratedValue(generator = "user_seq", strategy = GenerationType.SEQUENCE)
	int userId;

	String firstName;
	String middleName;
	String lastName;

	String email;
	String password;
	String contactNo;
	String aadhaarNo;
	String panNo;
	LocalDate dob;
	Gender gender;
	JobStatus jobStatus;
	String jobTitle;
	double salary;
	ResidenceArea residenceArea;
	MaritalStatus maritalStatus;
	Disability disabled;
	boolean isVerified;

	@OneToOne(mappedBy = "user")
	@JsonBackReference
	Document document;

	@OneToMany(mappedBy = "user")
	List<SukanyaAccount> sukanyaAccount;

	@OneToMany(mappedBy = "user")
	List<Enrollment> enroll;

	@OneToMany(mappedBy = "user")
	List<AccomodationStatus> accomodationStatus;

	@OneToMany(mappedBy = "user")
	@JsonBackReference
	List<Family> familyMenbers;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public JobStatus getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(JobStatus jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public ResidenceArea getResidenceArea() {
		return residenceArea;
	}

	public void setResidenceArea(ResidenceArea residenceArea) {
		this.residenceArea = residenceArea;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Disability getDisabled() {
		return disabled;
	}

	public void setDisabled(Disability disabled) {
		this.disabled = disabled;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public List<SukanyaAccount> getSukanyaAccount() {
		return sukanyaAccount;
	}

	public void setSukanyaAccount(List<SukanyaAccount> sukanyaAccount) {
		this.sukanyaAccount = sukanyaAccount;
	}

	public List<Enrollment> getEnroll() {
		return enroll;
	}

	public void setEnroll(List<Enrollment> enroll) {
		this.enroll = enroll;
	}

	public List<AccomodationStatus> getAccomodationStatus() {
		return accomodationStatus;
	}

	public void setAccomodationStatus(List<AccomodationStatus> accomodationStatus) {
		this.accomodationStatus = accomodationStatus;
	}

	public List<Family> getFamilyMenbers() {
		return familyMenbers;
	}

	public void setFamilyMenbers(List<Family> familyMenbers) {
		this.familyMenbers = familyMenbers;
	}

}
