package com.lti.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Accomodation {

	@Id
	@SequenceGenerator(name = "accomodationId_seq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "accomodationId_seq", strategy = GenerationType.SEQUENCE)
	int accomodationId;

	String name;
	String state;
	String city;
	String addressLine1;
	String addressLine2;
	String pincode;
	String landmark;
	int totalRoom;
	int roomAvailable;
	int capacity;
	boolean dayCareCentre;

	@ManyToOne
	@JoinColumn(name = "ngoId")
	Ngo ngo;

	@OneToMany(mappedBy = "accomodation")
	List<AccomodationStatus> accomodationStatuses;
	
	

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AccomodationStatus> getAccomodationStatuses() {
		return accomodationStatuses;
	}

	public void setAccomodationStatuses(List<AccomodationStatus> accomodationStatuses) {
		this.accomodationStatuses = accomodationStatuses;
	}

	public int getAccomodationId() {
		return accomodationId;
	}

	public void setAccomodationId(int accomodationId) {
		this.accomodationId = accomodationId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public int getTotalRoom() {
		return totalRoom;
	}

	public void setTotalRoom(int totalRoom) {
		this.totalRoom = totalRoom;
	}

	public int getRoomAvailable() {
		return roomAvailable;
	}

	public void setRoomAvailable(int roomAvailable) {
		this.roomAvailable = roomAvailable;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isDayCareCentre() {
		return dayCareCentre;
	}

	public void setDayCareCentre(boolean dayCareCentre) {
		this.dayCareCentre = dayCareCentre;
	}

	public Ngo getNgo() {
		return ngo;
	}

	public void setNgo(Ngo ngo) {
		this.ngo = ngo;
	}

	public List<AccomodationStatus> getAccomodation() {
		return accomodationStatuses;
	}

	public void setAccomodation(List<AccomodationStatus> accomodation) {
		this.accomodationStatuses = accomodation;
	}

	

}
