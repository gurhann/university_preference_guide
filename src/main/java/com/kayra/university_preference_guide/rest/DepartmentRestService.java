package com.kayra.university_preference_guide.rest;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.inject.Inject;
import com.kayra.university_preference_guide.model.Department;
import com.kayra.university_preference_guide.model.DepartmentSearchRequest;
import com.kayra.university_preference_guide.model.University;
import com.kayra.university_preference_guide.service.DepartmentService;

@Path("/department")
public class DepartmentRestService {

	@Inject
	private DepartmentService service;

	@GET
	@Path("/getByUniversity/{universityName}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<Department> getDepartmentsByUniversity(@PathParam("universityName") String universityname) {
		DepartmentSearchRequest req = new DepartmentSearchRequest();
		req.setUniversityList(Arrays.asList(new University(universityname)));
		return service.getDepartmentList(req);

	}
}