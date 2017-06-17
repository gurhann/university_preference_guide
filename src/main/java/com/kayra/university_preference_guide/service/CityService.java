package com.kayra.university_preference_guide.service;

import java.util.List;

import com.kayra.university_preference_guide.exception.InfoTypeNullException;
import com.kayra.university_preference_guide.exception.UnknownInfoTypeException;
import com.kayra.university_preference_guide.model.City;

public interface CityService {

	public List<City> getCities() throws UnknownInfoTypeException, InfoTypeNullException;
}
