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
import com.kayra.university_preference_guide.model.Faculty;
import com.kayra.university_preference_guide.persistence.MongoDriver;
import com.kayra.university_preference_guide.service.FacultyService;
import com.kayra.university_preference_guide.service.imp.FacultyServiceImpl;

public class FacultyServiceTest {

	@InjectMocks
	public FacultyService facultyService;

	@Mock
	public MongoDriver mongoDriver;

	@Before
	public void init() {
		facultyService = new FacultyServiceImpl(mongoDriver);
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getDepartmentsTest() {
		List<Document> docList = initialMockData();
		List<Faculty> facultyList;
		try {
			facultyList = facultyService.getFaculties();
			assertEquals(docList.size(), facultyList.size());
			for (int i = 0; i < docList.size(); i++) {
				assertEquals(docList.get(i).getString("value"), facultyList.get(i).getName());
			}
		} catch (UnknownInfoTypeException | InfoTypeNullException e) {
			fail();
		}
	}

	private List<Document> initialMockData() {
		ExtInfoSearchRequest req = new ExtInfoSearchRequest(InfoType.FACULTY);
		List<Document> docList = Arrays.asList(new Document("value", "İşletme Fakültesi"), new Document("value", "Yaşam ve Doğa Bilimleri Fakültesi"),
				new Document("value", "Mühendislik-Mimarlık Fakültesi"));
		try {
			when(mongoDriver.getExtInfosBy(req)).thenReturn(docList);
		} catch (UnknownInfoTypeException | InfoTypeNullException e) {
			e.printStackTrace();
		}
		return docList;
	}
}
