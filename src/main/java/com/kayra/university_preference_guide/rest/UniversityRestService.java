package com.kayra.university_preference_guide.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.inject.Inject;
import com.kayra.university_preference_guide.exception.InfoTypeNullException;
import com.kayra.university_preference_guide.exception.UnknownInfoTypeException;
import com.kayra.university_preference_guide.model.University;
import com.kayra.university_preference_guide.model.UniversitySearchRequest;
import com.kayra.university_preference_guide.service.UniversityService;

@Path("/university")
public class UniversityRestService {

	@Inject
	private UniversityService service;

	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<University> getUniversities() {
		try {
			return service.getAllUniversities();
		} catch (UnknownInfoTypeException | InfoTypeNullException e) {
			e.printStackTrace();
		}
		return null;
	}

	@POST
	@Path("/getUniversitiesByCriteria")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<University> getUniversities(UniversitySearchRequest searchDTO) {
		// TODO: Universite aramasina gore driverin ici doldurulacak
		return null;
	}
}
