package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class SukanyaDoc {

	@Id
	@SequenceGenerator(name = "sukanyaDocId_seq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "sukanyaDocId_seq", strategy = GenerationType.SEQUENCE)
	int sukanyaDocId;

	String aadhaarNo;
	String aadhaarLink;

	@OneToOne
	@JoinColumn(name = "accountId")
	SukanyaAccount sukanyaAccount;

	public int getSukanyaDocId() {
		return sukanyaDocId;
	}

	public void setSukanyaDocId(int sukanyaDocId) {
		this.sukanyaDocId = sukanyaDocId;
	}

	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public String getAadhaarLink() {
		return aadhaarLink;
	}

	public void setAadhaarLink(String aadhaarLink) {
		this.aadhaarLink = aadhaarLink;
	}

	public SukanyaAccount getSukanyaAccount() {
		return sukanyaAccount;
	}

	public void setSukanyaAccount(SukanyaAccount sukanyaAccount) {
		this.sukanyaAccount = sukanyaAccount;
	}

}
