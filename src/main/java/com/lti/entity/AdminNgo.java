package com.lti.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Admin_Ngo")
public class AdminNgo {

	@Id
	@SequenceGenerator(name = "adminngo_seq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "adminngo_seq", strategy = GenerationType.SEQUENCE)
	int adminNgoId;
	String admiName;
	boolean isVerified;


	public String getAdmiName() {
		return admiName;
	}

	public void setAdmiName(String admiName) {
		this.admiName = admiName;
	}

	public int getAdminngoId() {
		return adminNgoId;
	}

	public void setAdminngoId(int adminngoId) {
		this.adminNgoId = adminngoId;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
}
