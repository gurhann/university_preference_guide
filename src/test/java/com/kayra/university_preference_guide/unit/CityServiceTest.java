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
import com.kayra.university_preference_guide.model.City;
import com.kayra.university_preference_guide.model.ExtInfoSearchRequest;
import com.kayra.university_preference_guide.persistence.MongoDriver;
import com.kayra.university_preference_guide.service.CityService;
import com.kayra.university_preference_guide.service.imp.CityServiceImpl;

public class CityServiceTest {

	@InjectMocks
	public CityService cityService = new CityServiceImpl();

	@Mock
	public MongoDriver mongoDriver;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getCitiesTest() {
		List<Document> docList = initialMockData();
		List<City> cities;
		try {
			cities = cityService.getCities();
			assertEquals(docList.size(), cities.size());
			for (int i = 0; i < docList.size(); i++) {
				assertEquals(docList.get(i).getString("value"), cities.get(i).getName());
			}
		} catch (UnknownInfoTypeException | InfoTypeNullException e) {
			fail();
		}
	}

	private List<Document> initialMockData() {
		ExtInfoSearchRequest req = new ExtInfoSearchRequest(InfoType.CITY);
		List<Document> docList = Arrays.asList(new Document("value", "Erzurum"), new Document("value", "Karabük"), new Document("value", "Sakarya"));
		try {
			when(mongoDriver.getExtInfosBy(req)).thenReturn(docList);
		} catch (UnknownInfoTypeException | InfoTypeNullException e) {
			e.printStackTrace();
		}
		return docList;
	}
}
