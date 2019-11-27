package com.csye6225.fall2018.courseservice.resources;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.csye6225.fall2018.courseservice.datamodel.Student;
import com.csye6225.fall2018.courseservice.service.StudentsService;

@Path("student")
public class StudentsResource {

	StudentsService studentsService = new StudentsService();

	public StudentsResource() {
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudent() {
		return studentsService.getAllStudents();
	}

	@GET
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentById(@PathParam("studentId") String studId) {
		return studentsService.getStudent(studId);
	}

	@DELETE
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student deleteStudent(@PathParam("studentId") String studId) {
		return studentsService.deleteStudent(studId);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void addStudent(Student student) {

		studentsService.addStudent(student);

	}

	@PUT
	@Path("/{StudentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Student updateStudent(@PathParam("StudentId") String studentId, Student student) {
		return studentsService.updateStudentInformation(studentId, student);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/program/{ProgramId}")
	public List<Student> getAllStudentByProgram(@PathParam("ProgramId") String programId) {
		ArrayList<Student> arrayList = new ArrayList<Student>();
		return arrayList;

	}
	
}
