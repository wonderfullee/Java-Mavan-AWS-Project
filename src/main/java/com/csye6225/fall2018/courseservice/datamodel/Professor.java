package com.csye6225.fall2018.courseservice.datamodel;

import java.util.Date;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Professor")
public class Professor {
	private String Id;
	private String firstName;
	private String lastName;
	private String department;
	private String professorId;
	private String joiningDate;

	public Professor() {

	}

	public Professor(String Id, String professorId, String firstName, String lastName, String department,
			String joiningDate) {
		this.Id = Id;
		this.professorId = professorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.joiningDate = joiningDate;
	}

	@DynamoDBHashKey(attributeName = "Id")
	@DynamoDBAutoGeneratedKey
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	@DynamoDBAttribute(attributeName = "lastName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@DynamoDBAttribute(attributeName = "firstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@DynamoDBAttribute(attributeName = "department")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@DynamoDBAttribute(attributeName = "joiningDate")
	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	@DynamoDBIndexHashKey(attributeName = "professorId", globalSecondaryIndexName = "professorId-index")
	public String getProfessorId() {
		return professorId;
	}

	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}

}