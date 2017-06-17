package com.kayra.university_preference_guide.service.imp;

import java.util.List;

import org.bson.Document;

import com.kayra.university_preference_guide.constant.InfoType;
import com.kayra.university_preference_guide.exception.InfoTypeNullException;
import com.kayra.university_preference_guide.exception.UnknownInfoTypeException;
import com.kayra.university_preference_guide.mapper.ScoreTypeMapper;
import com.kayra.university_preference_guide.model.ExtInfoSearchRequest;
import com.kayra.university_preference_guide.model.ScoreType;
import com.kayra.university_preference_guide.persistence.MongoDriver;
import com.kayra.university_preference_guide.service.ScoreTypeService;

public class ScoreTypeServiceImpl implements ScoreTypeService {

	@Override
	public List<ScoreType> getScoreTypes() throws UnknownInfoTypeException, InfoTypeNullException {
		MongoDriver driver = MongoDriver.getInstance();
		ExtInfoSearchRequest req = new ExtInfoSearchRequest(InfoType.SCORE_TYPE);
		List<Document> scoreTypeDocList = driver.getExtInfosBy(req);
		return ScoreTypeMapper.documentList2ScoreTypeList(scoreTypeDocList);
	}

}
