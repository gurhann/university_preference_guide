package com.kayra.university_preference_guide.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;
import org.mockito.internal.util.StringUtil;

import com.google.inject.Inject;
import com.kayra.university_preference_guide.constant.Scholarship;
import com.kayra.university_preference_guide.model.BasicDepartmentSearchRequest;
import com.kayra.university_preference_guide.model.City;
import com.kayra.university_preference_guide.model.Department;
import com.kayra.university_preference_guide.model.DepartmentSearchRequest;
import com.kayra.university_preference_guide.model.Faculty;
import com.kayra.university_preference_guide.model.ScoreType;
import com.kayra.university_preference_guide.model.University;
import com.kayra.university_preference_guide.service.DepartmentService;

@Path("/department")
public class DepartmentRestService {

	@Inject
	private DepartmentService service;

	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<String> getAllDepartments() {
		return service.getAllDepartments();
	}

	@GET
	@Path("/getByUniversity/{universityName}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<Department> getDepartmentsByUniversity(@PathParam("universityName") String universityname) {
		DepartmentSearchRequest req = new DepartmentSearchRequest();
		req.setUniversityList(Arrays.asList(new University(universityname)));
		return service.getDepartmentList(req);

	}

	@GET
	@Path("/getByDepartmentName/{departmentName}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<Department> getDepartmentsByDepartmentName(@PathParam("departmentName") String departmentName) {
		DepartmentSearchRequest req = new DepartmentSearchRequest();
		req.setDepartmentNameList(Arrays.asList(departmentName));
		return service.getDepartmentList(req);
	}

	@POST
	@Path("/getDepartmentsByCriteria")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<Department> getDepartmentsByCriteria(DepartmentSearchRequest searchReq) {
		return service.getDepartmentList(searchReq);
	}

	@POST
	@Path("/basicSearchDepartment")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<Department> basicSearchDepartment(BasicDepartmentSearchRequest basicSearchReq) {
		DepartmentSearchRequest searchDTO = new DepartmentSearchRequest();
		if (StringUtils.isNotBlank(basicSearchReq.getScoreType())) {
			List<ScoreType> scoreTypeList = new ArrayList<>();
			scoreTypeList.add(new ScoreType(basicSearchReq.getScoreType()));
			searchDTO.setScoreTypeList(scoreTypeList);
		}

		if (StringUtils.isNotBlank(basicSearchReq.getFaculty())) {
			List<Faculty> facultyList = new ArrayList<>();
			facultyList.add(new Faculty(basicSearchReq.getFaculty()));
			searchDTO.setFacultyList(facultyList);
		}
		if (StringUtils.isNotBlank(basicSearchReq.getScholarShip())) {
			List<Scholarship> scholarshipList = new ArrayList<>();
			scholarshipList.add(Scholarship.getScholarship(basicSearchReq.getScholarShip()));
			searchDTO.setScholarshipList(scholarshipList);
		}

		if (StringUtils.isNotBlank(basicSearchReq.getUniversity())) {
			List<University> universityList = new ArrayList<>();
			universityList.add(new University(basicSearchReq.getUniversity()));
			searchDTO.setUniversityList(universityList);
		}

		if (StringUtils.isNotBlank(basicSearchReq.getDepartment())) {
			List<String> departmentNameList = new ArrayList<>();
			departmentNameList.add(basicSearchReq.getDepartment());
			searchDTO.setDepartmentNameList(departmentNameList);
		}

		if (StringUtils.isNotBlank(basicSearchReq.getCity())) {
			List<City> cityList = new ArrayList<>();
			cityList.add(new City(basicSearchReq.getCity()));
			searchDTO.setCityList(cityList);
		}
		
		if (basicSearchReq.getMinPoint() != null) {
			searchDTO.setMinPointEnd(basicSearchReq.getMinPoint());
			searchDTO.setMinPointStart(0d);
		}
		
		if (basicSearchReq.getMinSuccessSequence() != null) {
			searchDTO.setSuccessSequenceEnd(basicSearchReq.getMinSuccessSequence());
			searchDTO.setSuccessSequenceStart(0);
		}
		return service.getDepartmentList(searchDTO);
	}
}
