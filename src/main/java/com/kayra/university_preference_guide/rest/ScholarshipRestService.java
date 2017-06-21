package com.kayra.university_preference_guide.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.inject.Inject;
import com.kayra.university_preference_guide.constant.Scholarship;
import com.kayra.university_preference_guide.service.ScholarShipService;

@Path("/scholarship")
public class ScholarshipRestService {

	@Inject
	private ScholarShipService service;

	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<Scholarship> getScholarShips() {
		return service.getScholarShipTypes();
	}
}
