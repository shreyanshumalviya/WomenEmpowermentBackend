package com.lti.dto;

import com.lti.entity.Accomodation;

public class AccomodationRegistrationDto {
	String name;
    int ngo_id;
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
    
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getNgo_id() {
		return ngo_id;
	}



	public void setNgo_id(int ngo_id) {
		this.ngo_id = ngo_id;
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



	public Accomodation toAccomodation() {
		Accomodation accomodation = new Accomodation();
		
		accomodation.setName(name);
		accomodation.setAddressLine1(addressLine1);
		accomodation.setAddressLine2(addressLine2);
		accomodation.setCity(city);
		accomodation.setCapacity(capacity);
		accomodation.setState(state);
		accomodation.setLandmark(landmark);
		accomodation.setDayCareCentre(dayCareCentre);
		accomodation.setTotalRoom(totalRoom);
		accomodation.setPincode(pincode);
		accomodation.setRoomAvailable(totalRoom);
		
		return accomodation;
	}
    
    
}
