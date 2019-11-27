package com.csye6225.fall2018.courseservice.datamodel;


import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable (tableName = "Student")
public class Student {
	private String Id;
	private String studentId;
	private String firstName;
	private String lastName;
	private String department;
	private String joiningDate;
	private List<Course> registeredCourses;
	
	public Student() {
		
	}
	
	public Student(String Id,String studentId, String firstName, String lastName, String department,List<Course> registeredCourses) {
		this.Id = Id;
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.registeredCourses = registeredCourses;
	}
	
	
	@DynamoDBHashKey(attributeName = "Id")
	@DynamoDBAutoGeneratedKey
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	@DynamoDBIndexHashKey(attributeName = "studentId", globalSecondaryIndexName="studentId-index")
	public String getstudentId() {
		return studentId;
	}
	public void setstudentId(String studentId) {
		this.studentId = studentId;
	}
	
	@DynamoDBAttribute(attributeName = "firstName")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@DynamoDBAttribute(attributeName = "lastName")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@DynamoDBAttribute(attributeName = "department")
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@DynamoDBAttribute(attributeName = "registeredCourses")
	public List<Course> getregisteredCourses() {
		return registeredCourses;
	}
	public void setregisteredCourses(List<Course> registeredCourses) {
		this.registeredCourses = registeredCourses;
	}
	
	@DynamoDBAttribute(attributeName = "joiningDate")
	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	
			
}