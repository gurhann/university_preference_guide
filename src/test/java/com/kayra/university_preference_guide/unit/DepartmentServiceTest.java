package com.kayra.university_preference_guide.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
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

import com.kayra.university_preference_guide.model.City;
import com.kayra.university_preference_guide.model.Department;
import com.kayra.university_preference_guide.model.DepartmentSearchRequest;
import com.kayra.university_preference_guide.model.Faculty;
import com.kayra.university_preference_guide.model.University;
import com.kayra.university_preference_guide.persistence.MongoDriver;
import com.kayra.university_preference_guide.service.DepartmentService;
import com.kayra.university_preference_guide.service.imp.DepartmentServiceImpl;

public class DepartmentServiceTest {

	@InjectMocks
	public DepartmentService departmentService = new DepartmentServiceImpl();

	@Mock
	public MongoDriver mongoDriver;

	@BeforeClass
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getDepartmentListTest() {
		initialMockData();
		DepartmentSearchRequest req = getRequest();
		List<Department> departmentList = departmentService.getDepartmentList(req);
		assertEquals(1, departmentList.size());
		Department department = departmentList.get(0);
		assertEquals(new Faculty("Bilgisayar Mühendisliği"), department.getFaculty());
		University expectedUniversity = new University("ATATÜRK ÜNİVERSİTESİ");
		expectedUniversity.setPrivate(Boolean.FALSE);
		expectedUniversity.setCity(new City("Erzurum"));
		assertEquals(expectedUniversity, department.getUniversity());
		assertEquals((short) 62, department.getQuota());
		assertEquals((short) 62, department.getSettled());
		assertEquals("MF-4", department.getScoreType());
		assertEquals(279.5208, department.getMinPoint(), 4);
		assertEquals(383.9158, department.getMaxPoint(), 4);
		assertEquals(166000, department.getSuccesSequence());
		assertEquals(240.34331, department.getTopStudentOfSchoolMinPoint(), 5);
		assertEquals(240.34331, department.getTopStudentOfSchoolMaxPoint(), 5);
		assertEquals(false, department.isEnglish());
		assertEquals(false, department.isForKktc());
		assertEquals(false, department.isNight());
		assertNull(department.getScholarship());
	}

	private void initialMockData() {
		DepartmentSearchRequest req = getRequest();
		//@formatter:off
		when(mongoDriver.getDepartmentBySearchCriteria(req)).thenReturn(Arrays.asList(
				new Document("name","Bilgisayar Mühendisliği").append(
						"university", new Document("name","ATATÜRK ÜNİVERSİTESİ").append("city", "ERZURUM").append("isPrivate", false)
				).append("faculty_name", "Mühendislik Fakültesi").append("quota", 62).append("settled", 62)
				.append("score_type", "MF-4").append("min_point", 279.5208).append("max_point", 383.9158)
				.append("success_sequence", 166000).append("top_students_of_school_min_point", 240.34331)
				.append("top_students_of_school_max_point", 240.34331).append("is_night", false).append("is_english", false)
				.append("is_mtok", false).append("is_for_kktc", false))
		);
		//@formatter:on
	}

	private DepartmentSearchRequest getRequest() {
		DepartmentSearchRequest req = new DepartmentSearchRequest();
		req.setUniversityList(Arrays.asList(new University("Erzurum Atatürk Üniversitesi")));
		req.setMaxPointEnd(250.0);
		req.setMinPointEnd(225.0);
		req.setFacultyList(Arrays.asList(new Faculty("Mühendislik Fakültesi")));
		return req;
	}

}
