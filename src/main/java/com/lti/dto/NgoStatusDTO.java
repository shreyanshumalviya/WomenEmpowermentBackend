package com.lti.dto;

import java.time.LocalDate;

public class NgoStatusDTO {
	public int courses;
	public int learners;
	public int accomodations;
	public int residents;
	public int dayCareCenters;
	public LocalDate nextCourseStarts;
	public int courseFinished;

	public NgoStatusDTO() {
		courses = 0;
		learners = 0;
		accomodations = 0;
		residents = 0;
		dayCareCenters = 0;
		courseFinished = 0;
		
	}
}
