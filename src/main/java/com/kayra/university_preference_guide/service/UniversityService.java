package com.kayra.university_preference_guide.service;

import java.util.List;

import com.kayra.university_preference_guide.model.University;
import com.kayra.university_preference_guide.model.UniversitySearchRequest;

public interface UniversityService {

	public List<University> getUniversities(UniversitySearchRequest searchDTO);
}
