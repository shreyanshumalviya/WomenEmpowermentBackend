package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class AccomodationStatus {

	@Id
	@SequenceGenerator(name = "accomodationStatusId_seq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "accomodationStatusId_seq", strategy = GenerationType.SEQUENCE)
	int accomodationStatusId;

	@ManyToOne
	@JoinColumn(name = "accomodationId")
	Accomodation accomodation;

	LocalDate fromDate;
	LocalDate toDate;
	boolean dayCareAvailed;

	@ManyToOne
	@JoinColumn(name = "userId")
	User user;

	public int getAccomodationStatusId() {
		return accomodationStatusId;
	}

	public void setAccomodationStatusId(int accomodationStatusId) {
		this.accomodationStatusId = accomodationStatusId;
	}

	public Accomodation getAccomodation() {
		return accomodation;
	}

	public void setAccomodation(Accomodation accomodation) {
		this.accomodation = accomodation;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public boolean isDayCareAvailed() {
		return dayCareAvailed;
	}

	public void setDayCareAvailed(boolean dayCareAvailed) {
		this.dayCareAvailed = dayCareAvailed;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
