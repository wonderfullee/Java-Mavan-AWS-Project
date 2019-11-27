package com.csye6225.fall2018.courseservice.service;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.csye6225.fall2018.courseservice.datamodel.Board;
import com.csye6225.fall2018.courseservice.datamodel.Course;
import com.csye6225.fall2018.courseservice.datamodel.DynamoDbConnector;

public class CoursesService {
	static DynamoDbConnector dynamoDb;
	DynamoDBMapper mapper;

	public CoursesService() {
		dynamoDb = new DynamoDbConnector();
		dynamoDb.init();
		mapper = new DynamoDBMapper(dynamoDb.getClient());
	}

	public List<Course> getAllCourses() {
		List<Course> result = new ArrayList<Course>();
		List<Course> courseList = mapper.scan(Course.class, new DynamoDBScanExpression());
		for (Course c : courseList) {
			result.add(c);
		}
		return result;
	}

	public Course getOneCourse(String id) {
		return mapper.load(Course.class, id);
	}

	public Course deleteCourse(String id) {
		Course course = mapper.load(Course.class, id);
		mapper.delete(course);
		return course;
	}

	public void addCourse(Course course) {

		mapper.save(course);

	}

	public Course updateCourseInformation(String id, Course course) {
		Course oldCourse = mapper.load(Course.class, id);
		oldCourse.setCourseId(course.getCourseId());
		oldCourse.setBoardId(course.getBoardId());
		oldCourse.setDepartment(course.getDepartment());
		oldCourse.setListOfRegisteredStudents(course.getListOfRegisteredStudents());
		oldCourse.setListOfRegisteredRosters(course.getListOfRegisteredRosters());
		oldCourse.setProfessId(course.getProfessId());
		oldCourse.setTaId(course.getTaId());
		mapper.save(oldCourse);
		return oldCourse;
	}

}
