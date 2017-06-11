package com.kayra.university_preference_guide.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.kayra.university_preference_guide.constant.InfoType;
import com.kayra.university_preference_guide.exception.InfoTypeNullException;
import com.kayra.university_preference_guide.exception.UnknownInfoTypeException;
import com.kayra.university_preference_guide.model.City;
import com.kayra.university_preference_guide.model.ExtInfoSearchRequest;
import com.kayra.university_preference_guide.model.University;
import com.kayra.university_preference_guide.model.UniversitySearchRequest;
import com.kayra.university_preference_guide.persistence.MongoDriver;
import com.kayra.university_preference_guide.service.UniversityService;
import com.kayra.university_preference_guide.service.imp.UniversityServiceImpl;

public class UniversityServiceTest {

	@InjectMocks
	public UniversityService universityService = new UniversityServiceImpl();

	@Mock
	public MongoDriver mongoDriver;

	@BeforeClass
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getUniversitiesTest() {
		List<Document> docList = initialMockData();

		UniversitySearchRequest reqUniSearch = new UniversitySearchRequest();
		reqUniSearch.setIsPrivate(Boolean.FALSE);
		reqUniSearch.setCityList(Arrays.asList(new City("ERZURUM")));
		List<University> universities = universityService.getUniversities(reqUniSearch);
		assertEquals(docList.size(), universities.size());
		for (int i = 0; i < docList.size(); i++) {
			assertEquals(docList.get(i).getBoolean("isPrivate"), universities.get(i).isPrivate());
			assertEquals(docList.get(i).getString("city"), universities.get(i).getCity().getName());
			assertEquals(docList.get(i).getString("name"), universities.get(i).getName());
		}
	}

	private List<Document> initialMockData() {
		ExtInfoSearchRequest req = new ExtInfoSearchRequest(InfoType.UNIVERSITY);
		UniversitySearchRequest reqUniSearch = new UniversitySearchRequest();
		reqUniSearch.setIsPrivate(Boolean.FALSE);
		reqUniSearch.setCityList(Arrays.asList(new City("ERZURUM")));
		req.setSearchCriteria(reqUniSearch);
		//@formatter:off
		List<Document> docList = Arrays.asList(new Document("name", "ATATÜRK ÜNİVERSİTESİ").append("city", "ERZURUM").append("isPrivate", false),
											   new Document("name", "ERZURUM TEKNİK ÜNİVERSİTESİ").append("city", "ERZURUM").append("isPrivate", false));
		//@formatter:on
		try {
			when(mongoDriver.getExtInfosBy(req)).thenReturn(docList);
		} catch (UnknownInfoTypeException | InfoTypeNullException e) {
			e.printStackTrace();
		}
		return docList;

	}
	
}
