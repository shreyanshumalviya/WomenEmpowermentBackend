package com.lti.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.CourseDao;
import com.lti.dao.NgoDao;
import com.lti.dao.UserDao;
import com.lti.dto.CourseRegisterDTO;
import com.lti.entity.Course;
import com.lti.entity.Enrollment;
import com.lti.entity.Ngo;
import com.lti.entity.User;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDao courseDao;

	@Autowired
	NgoDao ngoDao;

	@Autowired
	UserDao userDao;
	
	@Override
	public Course createCourse(CourseRegisterDTO courseDTO) {
		if (courseDTO.getCourseId() != 0) {
			courseDTO.setCourseId(0);
		}

		Course course = courseDTO.toCourse();
		System.out.println(courseDTO.getNgo_id()+ " shreyanshu");
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

	@Override
	public List<Course> listAllCourses() {
		// TODO Auto-generated method stub
		return courseDao.listAllCourses();

	}

	@Override
	public Enrollment enrollForCourse(int courseId, int userId) {
		// TODO Auto-generated method stub
		Enrollment enrollment=new Enrollment();
		System.out.println(courseId);
		Course course=courseDao.getCourseById(courseId);
		System.out.println(course);
		User user=userDao.getUserById(userId);
		enrollment.setUser(user);
		enrollment.setCourse(course);
		enrollment.setRegistrationDate(LocalDate.now());
		
		return courseDao.enrollForCourse(enrollment);
	}

}
