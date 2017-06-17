package com.kayra.university_preference_guide.service.imp;

import java.util.List;

import org.bson.Document;

import com.kayra.university_preference_guide.constant.InfoType;
import com.kayra.university_preference_guide.exception.InfoTypeNullException;
import com.kayra.university_preference_guide.exception.UnknownInfoTypeException;
import com.kayra.university_preference_guide.mapper.UniversityMapper;
import com.kayra.university_preference_guide.model.ExtInfoSearchRequest;
import com.kayra.university_preference_guide.model.University;
import com.kayra.university_preference_guide.model.UniversitySearchRequest;
import com.kayra.university_preference_guide.persistence.MongoDriver;
import com.kayra.university_preference_guide.service.UniversityService;

public class UniversityServiceImpl implements UniversityService {

	@Override
	public List<University> getUniversities(UniversitySearchRequest searchDTO) throws UnknownInfoTypeException, InfoTypeNullException {
		MongoDriver driver = MongoDriver.getInstance();
		ExtInfoSearchRequest req = new ExtInfoSearchRequest(InfoType.UNIVERSITY);
		List<Document> universsityDocList = driver.getExtInfosBy(req);
		return UniversityMapper.documentList2UniversityList(universsityDocList);
	}

}
