package com.kayra.university_preference_guide.mapper;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.kayra.university_preference_guide.model.City;

public class CityMapper {

	private CityMapper() {

	}

	public static List<City> documentList2CityList(List<Document> docList) {
		List<City> cityList = new ArrayList<>();
		for (Document doc : docList) {
			cityList.add(document2City(doc));
		}
		return cityList;
	}

	public static City document2City(Document document) {
		City city = new City();
		city.setName(document.getString("value"));
		return city;
	}
}
