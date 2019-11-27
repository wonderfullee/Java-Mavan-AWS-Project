package com.csye6225.fall2018.courseservice.resources;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

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

import com.csye6225.fall2018.courseservice.datamodel.Professor;
import com.csye6225.fall2018.courseservice.service.ProfessorsService;

// .. /webapi/myresource
@Path("professor")
public class ProfessorsResource {

	ProfessorsService profService = new ProfessorsService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Professor> getProfessors() {

		return profService.getAllProfessors();
	}

	@GET
	@Path("/{professorId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Professor getProfessor(@PathParam("professorId") String Id) {
		System.out.println("uuuuuuuuuu");
		return profService.getProfessor(Id);
	}

	@DELETE
	@Path("/{professorId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Professor deleteProfessor(@PathParam("professorId") String Id) {
		return profService.deleteProfessor(Id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Professor addProfessor(Professor prof) {
		prof.setJoiningDate(new Date().toString());
		return profService.addProfessor(prof);
	}

	@PUT
	@Path("/{professorId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Professor updateProfessor(@PathParam("professorId") String Id, Professor prof) throws Exception {
		return profService.updateProfessorInformation(Id, prof);
	}

	@GET
	@Path("/department/{department}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Professor> getAllProfessorsBYDepartment(@PathParam("department") String department) {
		return profService.getALLProfessorByDepartment(department);
	}

}

