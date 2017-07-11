package com.kayra.university_preference_guide.model;

import java.math.BigDecimal;

import com.kayra.university_preference_guide.constant.Scholarship;

public class BasicDepartmentSearchRequest {

	private String scoreType;
	private String city;
	private String faculty;
	private String scholarShip;
	private String university;
	private String department;
	private Double minPoint;
	private Integer minSuccessSequence;

	public String getScoreType() {
		return scoreType;
	}

	public void setScoreType(String scoreType) {
		this.scoreType = scoreType;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getScholarShip() {
		return scholarShip;
	}

	public void setScholarShip(String scholarShip) {
		this.scholarShip = scholarShip;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Double getMinPoint() {
		return minPoint;
	}

	public void setMinPoint(Double minPoint) {
		this.minPoint = minPoint;
	}

	public Integer getMinSuccessSequence() {
		return minSuccessSequence;
	}

	public void setMinSuccessSequence(Integer minSuccessSequence) {
		this.minSuccessSequence = minSuccessSequence;
	}

}
