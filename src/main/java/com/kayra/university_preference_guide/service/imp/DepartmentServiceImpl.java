package com.kayra.university_preference_guide.service.imp;

import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kayra.university_preference_guide.mapper.DepartmentMapper;
import com.kayra.university_preference_guide.model.Department;
import com.kayra.university_preference_guide.model.DepartmentSearchRequest;
import com.kayra.university_preference_guide.persistence.MongoDriver;
import com.kayra.university_preference_guide.service.DepartmentService;

@Singleton
public class DepartmentServiceImpl implements DepartmentService {

	private MongoDriver driver;

	@Inject
	public DepartmentServiceImpl(MongoDriver driver) {
		this.driver = driver;
	}

	@Override
	public List<Department> getDepartmentList(DepartmentSearchRequest searchDTO) {
		return DepartmentMapper.documentList2DepartmentList(driver.getDepartmentBySearchCriteria(searchDTO));
	}

}
