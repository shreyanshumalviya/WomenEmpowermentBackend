package com.lti.dto;

import java.time.LocalDate;

import com.lti.entity.Family;
import com.lti.entity.Gender;
import com.lti.entity.Relation;

public class FamilyDetailsDto {
	int familyId;

	String firstName;
	String middleName;
	String lastName;
	Gender gender;
	LocalDate dob;
	Relation relation;
	String aadhaarNo;

	int userId;

	public int getFamilyId() {
		return familyId;
	}

	public void setFamilyId(int familyId) {
		this.familyId = familyId;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Relation getRelation() {
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}

	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Family toFamily() {
		Family family = new Family();

		family.setFamilyId(familyId);
		family.setFirstName(firstName);
		family.setMiddleName(middleName);
		family.setLastName(lastName);
		family.setGender(gender);
		family.setDob(dob);
		family.setRelation(relation);
		family.setAadhaarNo(aadhaarNo);

		return family;
	}
}
