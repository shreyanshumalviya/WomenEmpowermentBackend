package com.lti.dto;

import java.time.LocalDate;

import com.lti.entity.Course;
import com.lti.entity.Mode;
public class CourseRegisterDTO {
	int courseId;
	String courseTitle;
	String description;
	LocalDate startDate;
	int durationMonth;
	Mode courseMode;
	String location;
	boolean jobOffered;
	int vacancy;

	int ngo_id;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public int getDurationMonth() {
		return durationMonth;
	}

	public void setDurationMonth(int durationMonth) {
		this.durationMonth = durationMonth;
	}

	public Mode getCourseMode() {
		return courseMode;
	}

	public void setCourseMode(Mode courseMode) {
		this.courseMode = courseMode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isJobOffered() {
		return jobOffered;
	}

	public void setJobOffered(boolean jobOffered) {
		this.jobOffered = jobOffered;
	}

	public int getVacancy() {
		return vacancy;
	}

	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}

	public int getNgo_id() {
		return ngo_id;
	}

	public void setNgo_id(int ngo_id) {
		this.ngo_id = ngo_id;
	}
	
	public Course toCourse() {
		Course course = new Course();
		course.setCourseId(courseId);
		course.setCourseMode(courseMode);
		course.setCourseTitle(courseTitle);
		course.setDescription(description);
		course.setDurationMonth(durationMonth);
		course.setJobOffered(jobOffered);
		course.setLocation(location);
		course.setStartDate(startDate.plusDays(1));
		course.setVacancy(vacancy);
		
		return course;
	}

}
