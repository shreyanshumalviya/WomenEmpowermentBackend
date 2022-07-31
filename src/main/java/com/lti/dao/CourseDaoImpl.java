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
import com.lti.entity.User;

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
		
		return em.find(Course.class, courseId).getEnrollments();
	}

	@Override
	public List<Course> listAllCourses() {
		// TODO Auto-generated method stub
		String jpql="select c from Course c";
		TypedQuery<Course> query=em.createQuery(jpql, Course.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public Enrollment enrollForCourse(Enrollment enrollment) {
		// TODO Auto-generated method stub
		return em.merge(enrollment);
	}
//	temprory remove once user dao is ready
	public User getNgoById(int ngoId) {
		return em.find(User.class, ngoId);
	}
	public Course getCourseById(int courseId) {
		return em.find(Course.class, courseId);
	}

}
