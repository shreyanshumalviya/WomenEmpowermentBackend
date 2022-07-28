package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Course;
import com.lti.entity.Enrollment;
import com.lti.entity.Ngo;

@Repository
public class CourseDaoImpl implements CourseDao {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public Course createCourse(Course course) {
		return em.merge(course);// TODO in service check courseId should not be present
	}

	@Override
	public List<Course> listCoursesByNgo(int ngoId) {
		return em.find(Ngo.class, ngoId).getCourse();
	}

	@Override
	public List<Enrollment> listUserEnrolledForCourse(int courseId) {
		
		return em.find(Course.class, courseId).getEnroll();
	}

}
