package com.kayra.university_preference_guide.service;

import java.util.List;

import com.kayra.university_preference_guide.exception.InfoTypeNullException;
import com.kayra.university_preference_guide.exception.UnknownInfoTypeException;
import com.kayra.university_preference_guide.model.Faculty;

public interface FacultyService {

	public List<Faculty> getFaculties() throws UnknownInfoTypeException, InfoTypeNullException;
}
