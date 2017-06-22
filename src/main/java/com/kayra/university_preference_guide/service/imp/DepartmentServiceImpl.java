package com.kayra.university_preference_guide.service.imp;

import java.util.ArrayList;
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

	@Override
	public List<String> getAllDepartments() {
		List<String> nameList = new ArrayList<String>();
		List<String> allDepartmentNames = driver.getAllDepartmentNames();
		for (String departmentName : allDepartmentNames) {
			int brackedIndex = checkBracket(departmentName);
			if (brackedIndex == -1) {
				addToNameList(departmentName, nameList);
			} else {
				addToNameList(departmentName.substring(0, brackedIndex - 1), nameList);
			}
		}

		return nameList;
	}

	private int checkBracket(String name) {
		return name.indexOf("(");
	}

	private void addToNameList(String name, List<String> nameList) {
		if (!nameList.contains(name)) {
			nameList.add(name);
		}
	}

}
