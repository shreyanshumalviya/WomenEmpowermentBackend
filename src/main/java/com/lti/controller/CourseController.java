package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.CourseRegisterDTO;
import com.lti.entity.Course;
import com.lti.service.CourseServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseServiceImpl courseService;
	
	@RequestMapping (value = "/register", method = RequestMethod.POST)
	public Course signup(@RequestBody CourseRegisterDTO course) {
		System.out.println("here");

		return courseService.createCourse(course);
	}	
	
	@GetMapping("/list-course-by-ngo/{ngoId}")
	public List<Course> listCourse(@PathVariable int ngoId){
		return courseService.listCoursesByNgo(ngoId);
	}
}
