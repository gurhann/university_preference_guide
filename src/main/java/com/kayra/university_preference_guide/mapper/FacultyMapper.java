package com.kayra.university_preference_guide.mapper;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.kayra.university_preference_guide.model.Faculty;

public class FacultyMapper {

	private FacultyMapper() {

	}

	public static List<Faculty> documentList2FacultyList(List<Document> docList) {
		List<Faculty> facultyList = new ArrayList<>();
		for (Document doc : docList) {
			facultyList.add(document2Faculty(doc));
		}
		return facultyList;
	}

	public static Faculty document2Faculty(Document doc) {
		Faculty faculty = new Faculty();
		faculty.setName(doc.getString("value"));
		return faculty;
	}
}
