package com.csye6225.fall2018.courseservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import com.csye6225.fall2018.courseservice.datamodel.Course;
import com.csye6225.fall2018.courseservice.datamodel.DynamoDbConnector;
import com.csye6225.fall2018.courseservice.datamodel.Student;
import com.csye6225.fall2018.courseservice.datamodel.Professor;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;

public class StudentsService {

	static DynamoDbConnector dynamoDb;
	DynamoDBMapper mapper;

	public StudentsService() {
		dynamoDb = new DynamoDbConnector();
		dynamoDb.init();
		mapper = new DynamoDBMapper(dynamoDb.getClient());

	}

	// Get All Student Info
	public List<Student> getAllStudents() {
		List<Student> result = new ArrayList<Student>();
		List<Student> students = mapper.scan(Student.class, new DynamoDBScanExpression());
		for (Student s : students) {
			result.add(s);
		}
		return result;
	}

	// Add student
	public Student addStudent(Student student) {
		student.setJoiningDate(new Date().toString());
		String studentId = (student.getFirstName() + "_" + student.getLastName() + "_" + student.getDepartment())
				.toLowerCase();
		student.setstudentId(studentId);
		mapper.save(student);
		return student;
	}

	// Get requested Student Info
	public Student getStudent(String Id) {
		return mapper.load(Student.class, Id);
	}

	// Deleting a Student
	public Student deleteStudent(String Id) {
		Student student = mapper.load(Student.class, Id);
		mapper.delete(student);
		return student;
	}

	// Updating Student Info
	public Student updateStudentInformation(String Id, Student student) {
		Student oldStudent = mapper.load(Student.class, Id);
		oldStudent.setFirstName(student.getFirstName());
		oldStudent.setLastName(student.getLastName());
		oldStudent.setJoiningDate(new Date().toString());
		oldStudent.setregisteredCourses(student.getregisteredCourses());
		oldStudent.setDepartment(student.getDepartment());
		oldStudent.setstudentId(student.getstudentId());
		mapper.save(oldStudent);
		return oldStudent;
	}

}
