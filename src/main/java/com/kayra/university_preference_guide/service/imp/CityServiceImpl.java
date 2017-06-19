package com.kayra.university_preference_guide.service.imp;

import java.util.List;

import org.bson.Document;

import com.kayra.university_preference_guide.constant.InfoType;
import com.kayra.university_preference_guide.exception.InfoTypeNullException;
import com.kayra.university_preference_guide.exception.UnknownInfoTypeException;
import com.kayra.university_preference_guide.mapper.CityMapper;
import com.kayra.university_preference_guide.model.City;
import com.kayra.university_preference_guide.model.ExtInfoSearchRequest;
import com.kayra.university_preference_guide.persistence.MongoDriver;
import com.kayra.university_preference_guide.service.CityService;

public class CityServiceImpl implements CityService {

	private MongoDriver driver;

	public CityServiceImpl(MongoDriver driver) {
		this.driver = driver;
	}

	@Override
	public List<City> getCities() throws UnknownInfoTypeException, InfoTypeNullException {
		ExtInfoSearchRequest req = new ExtInfoSearchRequest(InfoType.CITY);
		List<Document> cityDocList = driver.getExtInfosBy(req);
		return CityMapper.documentList2CityList(cityDocList);
	}

}
