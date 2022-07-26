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

@Entity
public class Family {

	@Id
	@SequenceGenerator(name = "family_seq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "family_seq", strategy = GenerationType.SEQUENCE)
	int familyId;

	String firstName;
	String lastName;
	Gender gender;
	LocalDate dob;
	Relation relation;
	int adharNo;

	@ManyToOne
	@JoinColumn(name = "userId")
	User user;

	@OneToOne(mappedBy = "family")
	FamilyDocument familydoc;

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

	public int getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(int adharNo) {
		this.adharNo = adharNo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public FamilyDocument getFamilydoc() {
		return familydoc;
	}

	public void setFamilydoc(FamilyDocument familydoc) {
		this.familydoc = familydoc;
	}
}
