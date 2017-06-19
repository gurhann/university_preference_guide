package com.kayra.university_preference_guide.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.kayra.university_preference_guide.constant.InfoType;
import com.kayra.university_preference_guide.exception.InfoTypeNullException;
import com.kayra.university_preference_guide.exception.UnknownInfoTypeException;
import com.kayra.university_preference_guide.model.ExtInfoSearchRequest;
import com.kayra.university_preference_guide.model.ScoreType;
import com.kayra.university_preference_guide.persistence.MongoDriver;
import com.kayra.university_preference_guide.service.ScoreTypeService;
import com.kayra.university_preference_guide.service.imp.ScoreTypeServiceImpl;

public class ScoreTypeServiceTest {

	@InjectMocks
	public ScoreTypeService scoreTypeService;

	@Mock
	public MongoDriver mongoDriver;

	@Before
	public void init() {
		scoreTypeService = new ScoreTypeServiceImpl(mongoDriver);
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getScoreTypesTest() {
		List<Document> docList = initialMockData();
		List<ScoreType> scoreTypes;
		try {
			scoreTypes = scoreTypeService.getScoreTypes();
			assertEquals(docList.size(), scoreTypes.size());
			for (int i = 0; i < docList.size(); i++) {
				assertEquals(docList.get(i).getString("value"), scoreTypes.get(i).getName());
			}
		} catch (UnknownInfoTypeException | InfoTypeNullException e) {
			fail();
		}
	}

	private List<Document> initialMockData() {
		ExtInfoSearchRequest req = new ExtInfoSearchRequest(InfoType.SCORE_TYPE);
		List<Document> docList = Arrays.asList(new Document("value", "YGS-1"), new Document("value", "MF-2"), new Document("value", "DİL-1"));
		try {
			when(mongoDriver.getExtInfosBy(req)).thenReturn(docList);
		} catch (UnknownInfoTypeException | InfoTypeNullException e) {
			e.printStackTrace();
		}
		return docList;
	}
}
