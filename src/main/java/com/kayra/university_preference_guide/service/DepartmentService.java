package com.kayra.university_preference_guide.service;

import java.util.List;

import com.kayra.university_preference_guide.model.Department;
import com.kayra.university_preference_guide.model.DepartmentSearchRequest;

public interface DepartmentService {

	public List<Department> getDepartmentList(DepartmentSearchRequest searchDTO);

	public List<String> getAllDepartments();
}
