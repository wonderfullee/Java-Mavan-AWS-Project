package com.csye6225.fall2018.courseservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.management.Query;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.csye6225.fall2018.courseservice.datamodel.DynamoDbConnector;
import com.csye6225.fall2018.courseservice.datamodel.Professor;
import com.csye6225.fall2018.courseservice.datamodel.Student;
import com.sun.webkit.ThemeClient;

public class ProfessorsService {

	static DynamoDbConnector dynamoDb;
	DynamoDBMapper mapper;

	public ProfessorsService() {
		dynamoDb = new DynamoDbConnector();
		dynamoDb.init();
		mapper = new DynamoDBMapper(dynamoDb.getClient());

	}

	public List<Professor> getAllProfessors() {
		List<Professor> list = mapper.scan(Professor.class, new DynamoDBScanExpression());
		return list;
	}

	public Professor addProfessor(Professor professor) {
		mapper.save(professor);
		return professor;
	}

	// Getting One Professor
	public Professor getProfessor(String professorId) {
		Professor prof = mapper.load(Professor.class, professorId);
		return prof;
	}

	// Deleting a professor
	public Professor deleteProfessor(String Id) {
		Professor professor = mapper.load(Professor.class, Id);
		mapper.delete(professor);
		return professor;
	}

	public Professor updateProfessorInformation(String Id, Professor newProf) {
		Professor oldProfessor = mapper.load(Professor.class, Id);
		oldProfessor.setJoiningDate(new Date().toString());
		oldProfessor.setFirstName(newProf.getFirstName());
		oldProfessor.setLastName(newProf.getLastName());
		oldProfessor.setDepartment(newProf.getDepartment());

		mapper.save(oldProfessor);
		return oldProfessor;
	}

	public List<Professor> getALLProfessorByDepartment(String department) {
		if (department == null || department.length() == 0) {
			return getAllProfessors();
		}

		Map<String, AttributeValue> map = new HashMap<String, AttributeValue>();
		map.put(":department", new AttributeValue().withS(department));
		DynamoDBScanExpression dbScanExpression = new DynamoDBScanExpression()
				.withFilterExpression("department = :department").withExpressionAttributeValues(map);

		List<Professor> list = mapper.scan(Professor.class, dbScanExpression);
		return list;

	}

}
