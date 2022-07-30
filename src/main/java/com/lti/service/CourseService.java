package com.lti.service;

import java.util.List;

import com.lti.dto.CourseRegisterDTO;
import com.lti.entity.Course;
import com.lti.entity.Enrollment;

public interface CourseService {

	Course createCourse(CourseRegisterDTO course);
	List<Course> listCoursesByNgo(int ngoId);
	List<Enrollment> listUserEnrolledForCourse(int courseId);
	List<Course> listAllCourses();
	Enrollment enrollForCourse(int courseId,int userId);
	
}
