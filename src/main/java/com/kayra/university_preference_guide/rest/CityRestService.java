package com.kayra.university_preference_guide.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.inject.Inject;
import com.kayra.university_preference_guide.exception.InfoTypeNullException;
import com.kayra.university_preference_guide.exception.UnknownInfoTypeException;
import com.kayra.university_preference_guide.model.City;
import com.kayra.university_preference_guide.service.CityService;

@Path("/city")
public class CityRestService {

	@Inject
	private CityService cityService;

	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<City> getCities() {
		try {
			System.out.println(cityService.toString());
			return cityService.getCities();
		} catch (UnknownInfoTypeException | InfoTypeNullException e) {
			e.printStackTrace();
		}
		return null;
	}

}
