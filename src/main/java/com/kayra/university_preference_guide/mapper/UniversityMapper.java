package com.kayra.university_preference_guide.mapper;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.kayra.university_preference_guide.model.City;
import com.kayra.university_preference_guide.model.University;

public class UniversityMapper {

	private UniversityMapper() {

	}

	public static List<University> documentList2UniversityList(List<Document> docList) {
		List<University> universityList = new ArrayList<>();
		for (Document doc : docList) {
			universityList.add(document2University((Document) doc.get("value")));
		}
		return universityList;
	}

	public static University document2University(Document doc) {
		University university = new University();
		university.setName(doc.getString("name"));
		university.setCity(new City(doc.getString("city")));
		university.setPrivate(doc.getBoolean("isPrivate", false));
		return university;
	}
}
