package com.kayra.university_preference_guide.mapper;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.kayra.university_preference_guide.constant.Scholarship;
import com.kayra.university_preference_guide.model.Department;
import com.kayra.university_preference_guide.model.Faculty;
import com.kayra.university_preference_guide.model.ScoreType;

public class DepartmentMapper {

	private DepartmentMapper() {

	}

	public static List<Department> documentList2DepartmentList(List<Document> docList) {
		List<Department> departmentList = new ArrayList<Department>();
		for (Document doc : docList) {
			departmentList.add(document2Department(doc));
		}
		return departmentList;
	}

	public static Department document2Department(Document doc) {
		Department department = new Department();
		department.setName(doc.getString("name"));
		department.setFaculty(new Faculty(doc.getString("faculty_name")));
		department.setQuota(doc.getInteger("quota").shortValue());
		department.setSettled((short) doc.getInteger("settled", 0));
		department.setScoreType(new ScoreType(doc.getString("score_type")));
		department.setMinPoint(doc.getDouble("min_point"));
		department.setMaxPoint(doc.getDouble("max_point"));
		department.setSuccesSequence(doc.getInteger("success_sequence"));
		department.setTopStudentOfSchoolMinPoint(doc.getDouble("top_students_of_school_min_point"));
		department.setTopStudentOfSchoolMaxPoint(doc.getDouble("top_students_of_school_max_point"));
		department.setNight(doc.getBoolean("is_night"));
		department.setEnglish(doc.getBoolean("is_english"));
		department.setMTOK(doc.getBoolean("is_mtok"));
		department.setForKktc(doc.getBoolean("is_for_kktc"));
		department.setScholarship(Scholarship.getScholarship(doc.getString("scholarship")));
		department.setUniversity(UniversityMapper.document2University((Document) doc.get("university")));
		return department;
	}

}
