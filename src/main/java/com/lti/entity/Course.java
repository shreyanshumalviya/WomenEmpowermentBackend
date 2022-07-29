package com.lti.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
public class Course {

	@Id
	@SequenceGenerator(name = "course_seq", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "course_seq", strategy = GenerationType.SEQUENCE)
	int courseId;

	String courseTitle;
	String description;
	LocalDate startDate;
	int durationMonth;
	Mode courseMode;
	String location;
	boolean jobOffered;
	int vacancy;

	@ManyToOne
	@JoinColumn(name = "ngoId")
	Ngo ngo;

	@OneToMany(mappedBy = "course")
	List<Enrollment> enrollments;

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

	public Ngo getNgo() {
		return ngo;
	}

	public void setNgo(Ngo ngo) {
		this.ngo = ngo;
	}

	public List<Enrollment> getEnroll() {
		return enrollments;
	}

	public void setEnroll(List<Enrollment> enroll) {
		this.enrollments = enroll;
	}

}
