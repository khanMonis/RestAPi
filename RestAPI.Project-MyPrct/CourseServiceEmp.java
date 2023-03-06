     package com.springrest.services;

import java.util.List;

import com.springrest.entities.Course;

public interface CourseServiceEmp {
	
	public List<Course> getCourses();
	
	public Course getCourseById(long courseId);
	
	public Course addCourse(Course course);

	public Course updateCourse(Course course);

	public void deleteCourse(long parseLong);

}
