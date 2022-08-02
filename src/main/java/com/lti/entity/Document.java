package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Document {
	@Id
	@SequenceGenerator(name = "doc_seq", initialValue = 10001, allocationSize = 1)
	@GeneratedValue(generator = "doc_seq", strategy = GenerationType.SEQUENCE)
	int documentId;

	String aadhaarNo;
	String aadhaarLink;
	String panNo;
	String panLink;

	@OneToOne
	@JoinColumn(name = "userId")
	@JsonManagedReference
	User user;

	public int getDocumentId() {
		return documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(String adharNo) {
		this.aadhaarNo = adharNo;
	}

	public String getAadhaarLink() {
		return aadhaarLink;
	}

	public void setAadhaarLink(String adharLink) {
		this.aadhaarLink = adharLink;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getPanLink() {
		return panLink;
	}

	public void setPanLink(String panLink) {
		this.panLink = panLink;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
