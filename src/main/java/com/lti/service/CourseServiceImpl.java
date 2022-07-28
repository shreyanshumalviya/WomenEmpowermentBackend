package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.CourseDao;
import com.lti.dao.NgoDao;
import com.lti.dto.CourseRegisterDTO;
import com.lti.entity.Course;
import com.lti.entity.Enrollment;
import com.lti.entity.Ngo;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDao courseDao;

	@Autowired
	NgoDao ngoDao;

	@Override
	public Course createCourse(CourseRegisterDTO courseDTO) {
		if (courseDTO.getCourseId() != 0) {
			courseDTO.setCourseId(0);
		}

		Course course = courseDTO.toCourse();
		Ngo ngo = ngoDao.getNgoById(courseDTO.getNgo_id());
		System.out.println(ngo.getEmail());
		try {
			course.setNgo(ngo);
		} catch (Exception e) {
			System.out.println("Cant set NGO");
		}
		return courseDao.createCourse(course);
	}

	@Override
	public List<Course> listCoursesByNgo(int ngoId) {
		return courseDao.listCoursesByNgo(ngoId);
	}

	@Override
	public List<Enrollment> listUserEnrolledForCourse(int courseId) {
		return courseDao.listUserEnrolledForCourse(courseId);
	}

}
