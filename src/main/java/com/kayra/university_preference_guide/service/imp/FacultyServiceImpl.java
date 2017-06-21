package com.kayra.university_preference_guide.service.imp;

import java.util.List;

import org.bson.Document;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kayra.university_preference_guide.constant.InfoType;
import com.kayra.university_preference_guide.exception.InfoTypeNullException;
import com.kayra.university_preference_guide.exception.UnknownInfoTypeException;
import com.kayra.university_preference_guide.mapper.FacultyMapper;
import com.kayra.university_preference_guide.model.ExtInfoSearchRequest;
import com.kayra.university_preference_guide.model.Faculty;
import com.kayra.university_preference_guide.persistence.MongoDriver;
import com.kayra.university_preference_guide.service.FacultyService;

@Singleton
public class FacultyServiceImpl implements FacultyService {
	
	private MongoDriver driver;
	
	@Inject
	public FacultyServiceImpl(MongoDriver driver) {
		this.driver = driver;
	}

	@Override
	public List<Faculty> getFaculties() throws UnknownInfoTypeException, InfoTypeNullException {
		ExtInfoSearchRequest req = new ExtInfoSearchRequest(InfoType.FACULTY);
		List<Document> facultyDocList = driver.getExtInfosBy(req);
		return FacultyMapper.documentList2FacultyList(facultyDocList);
	}

}
