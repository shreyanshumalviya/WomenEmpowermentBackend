package com.lti.dao;

import java.util.List;

import com.lti.entity.Course;
import com.lti.entity.Enrollment;
import com.lti.entity.User;

public interface CourseDao {

	Course createCourse(Course course);
	List<Course> listCoursesByNgo(int ngoId);
	List<Enrollment> listUserEnrolledForCourse(int courseId);
}
