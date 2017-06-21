package com.kayra.university_preference_guide.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.inject.Inject;
import com.kayra.university_preference_guide.exception.InfoTypeNullException;
import com.kayra.university_preference_guide.exception.UnknownInfoTypeException;
import com.kayra.university_preference_guide.model.ScoreType;
import com.kayra.university_preference_guide.service.ScoreTypeService;

@Path("/scoreType")
public class ScoreTypeRestService {

	@Inject
	private ScoreTypeService scoreTypeService;

	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<ScoreType> getScoreTypes() {
		try {
			return scoreTypeService.getScoreTypes();
		} catch (UnknownInfoTypeException | InfoTypeNullException e) {
			e.printStackTrace();
		}

		return null;
	}
}
