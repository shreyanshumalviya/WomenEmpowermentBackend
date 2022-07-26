package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class FamilyDocument {

	@Id
	@SequenceGenerator(name = "familyDoc_seq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "familyDoc_seq", strategy = GenerationType.SEQUENCE)
	int familyDocId;
	String adharNo;
	String adharLink;

	@OneToOne
	@JoinColumn(name = "familyId")
	Family family;

	public int getFamilyDocId() {
		return familyDocId;
	}

	public void setFamilyDocId(int familyDocId) {
		this.familyDocId = familyDocId;
	}

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}

	public String getAdharLink() {
		return adharLink;
	}

	public void setAdharLink(String adharLink) {
		this.adharLink = adharLink;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

}
