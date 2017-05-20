package com.kayra.university_preference_guide.unit;

import org.junit.BeforeClass;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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

}
