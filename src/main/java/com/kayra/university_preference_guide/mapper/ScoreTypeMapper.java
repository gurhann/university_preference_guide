package com.kayra.university_preference_guide.mapper;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.kayra.university_preference_guide.model.ScoreType;

public class ScoreTypeMapper {

	private ScoreTypeMapper() {

	}

	public static List<ScoreType> documentList2ScoreTypeList(List<Document> docList) {
		List<ScoreType> scoreTypeList = new ArrayList<>();
		for (Document doc : docList) {
			scoreTypeList.add(document2ScoreType(doc));
		}
		return scoreTypeList;
	}

	public static ScoreType document2ScoreType(Document doc) {
		ScoreType scoreType = new ScoreType();
		scoreType.setName(doc.getString("name"));
		return scoreType;
	}

}
