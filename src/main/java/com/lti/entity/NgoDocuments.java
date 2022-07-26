package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class NgoDocuments {

	@Id
	@SequenceGenerator(name = "ngoDoc_seq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "ngoDoc_seq", strategy = GenerationType.SEQUENCE)
	int ngoDocId;

	String certificateNo;
	String certificateLink;

	@OneToOne
	@JoinColumn(name = "ngoId")
	Ngo ngo;

	public int getNgoDocId() {
		return ngoDocId;
	}

	public void setNgoDocId(int ngoDocId) {
		this.ngoDocId = ngoDocId;
	}

	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	public String getCertificateLink() {
		return certificateLink;
	}

	public void setCertificateLink(String certificateLink) {
		this.certificateLink = certificateLink;
	}

	public Ngo getNgo() {
		return ngo;
	}

	public void setNgo(Ngo ngo) {
		this.ngo = ngo;
	}

}
