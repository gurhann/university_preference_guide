package com.kayra.university_preference_guide.service.imp;

import java.util.Arrays;
import java.util.List;

import com.google.inject.Singleton;
import com.kayra.university_preference_guide.constant.Scholarship;
import com.kayra.university_preference_guide.service.ScholarShipService;

@Singleton
public class ScholarShipServiceImpl implements ScholarShipService {

	@Override
	public List<Scholarship> getScholarShipTypes() {
		return Arrays.asList(Scholarship.values());
	}

}
