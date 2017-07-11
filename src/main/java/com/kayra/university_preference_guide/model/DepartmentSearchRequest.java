package com.kayra.university_preference_guide.model;

import java.util.List;

import com.kayra.university_preference_guide.constant.Scholarship;

public class DepartmentSearchRequest {

	private List<University> universityList;
	private List<Faculty> facultyList;
	private List<String> departmentNameList;
	private Boolean isThereEmptyScape;
	private List<ScoreType> scoreTypeList;
	private Double minPointStart;
	private Double minPointEnd;
	private Double maxPointStart;
	private Double maxPointEnd;
	private Integer successSequenceStart;
	private Integer successSequenceEnd;
	private Double topStudentOfSchoolMinPointStart;
	private Double topStudentOfSchoolMinPointEnd;
	private Double topStudentOfSchoolMaxPointStart;
	private Double topStudentOfSchoolMaxPointEnd;
	private Boolean isNight;
	private Boolean isEnglish;
	private Boolean isMTOK;
	private List<Scholarship> scholarshipList;
	private Boolean isForKktc;
	private List<City> cityList;

	public List<University> getUniversityList() {
		return universityList;
	}

	public void setUniversityList(List<University> universityList) {
		this.universityList = universityList;
	}

	public List<Faculty> getFacultyList() {
		return facultyList;
	}

	public void setFacultyList(List<Faculty> facultyList) {
		this.facultyList = facultyList;
	}

	public List<String> getDepartmentNameList() {
		return departmentNameList;
	}

	public void setDepartmentNameList(List<String> departmentNameList) {
		this.departmentNameList = departmentNameList;
	}

	public Boolean getIsThereEmptyScape() {
		return isThereEmptyScape;
	}

	public void setIsThereEmptyScape(Boolean isThereEmptyScape) {
		this.isThereEmptyScape = isThereEmptyScape;
	}

	public List<ScoreType> getScoreTypeList() {
		return scoreTypeList;
	}

	public void setScoreTypeList(List<ScoreType> scoreTypeList) {
		this.scoreTypeList = scoreTypeList;
	}

	public Double getMinPointStart() {
		return minPointStart;
	}

	public void setMinPointStart(Double minPointStart) {
		this.minPointStart = minPointStart;
	}

	public Double getMinPointEnd() {
		return minPointEnd;
	}

	public void setMinPointEnd(Double minPointEnd) {
		this.minPointEnd = minPointEnd;
	}

	public Double getMaxPointStart() {
		return maxPointStart;
	}

	public void setMaxPointStart(Double maxPointStart) {
		this.maxPointStart = maxPointStart;
	}

	public Double getMaxPointEnd() {
		return maxPointEnd;
	}

	public void setMaxPointEnd(Double maxPointEnd) {
		this.maxPointEnd = maxPointEnd;
	}

	public Integer getSuccessSequenceStart() {
		return successSequenceStart;
	}

	public void setSuccessSequenceStart(Integer successSequenceStart) {
		this.successSequenceStart = successSequenceStart;
	}

	public Integer getSuccessSequenceEnd() {
		return successSequenceEnd;
	}

	public void setSuccessSequenceEnd(Integer successSequenceEnd) {
		this.successSequenceEnd = successSequenceEnd;
	}

	public Double getTopStudentOfSchoolMinPointStart() {
		return topStudentOfSchoolMinPointStart;
	}

	public void setTopStudentOfSchoolMinPointStart(Double topStudentOfSchoolMinPointStart) {
		this.topStudentOfSchoolMinPointStart = topStudentOfSchoolMinPointStart;
	}

	public Double getTopStudentOfSchoolMinPointEnd() {
		return topStudentOfSchoolMinPointEnd;
	}

	public void setTopStudentOfSchoolMinPointEnd(Double topStudentOfSchoolMinPointEnd) {
		this.topStudentOfSchoolMinPointEnd = topStudentOfSchoolMinPointEnd;
	}

	public Double getTopStudentOfSchoolMaxPointStart() {
		return topStudentOfSchoolMaxPointStart;
	}

	public void setTopStudentOfSchoolMaxPointStart(Double topStudentOfSchoolMaxPointStart) {
		this.topStudentOfSchoolMaxPointStart = topStudentOfSchoolMaxPointStart;
	}

	public Double getTopStudentOfSchoolMaxPointEnd() {
		return topStudentOfSchoolMaxPointEnd;
	}

	public void setTopStudentOfSchoolMaxPointEnd(Double topStudentOfSchoolMaxPointEnd) {
		this.topStudentOfSchoolMaxPointEnd = topStudentOfSchoolMaxPointEnd;
	}

	public Boolean getIsNight() {
		return isNight;
	}

	public void setIsNight(Boolean isNight) {
		this.isNight = isNight;
	}

	public Boolean getIsEnglish() {
		return isEnglish;
	}

	public void setIsEnglish(Boolean isEnglish) {
		this.isEnglish = isEnglish;
	}

	public Boolean getIsMTOK() {
		return isMTOK;
	}

	public void setIsMTOK(Boolean isMTOK) {
		this.isMTOK = isMTOK;
	}

	public List<Scholarship> getScholarshipList() {
		return scholarshipList;
	}

	public void setScholarshipList(List<Scholarship> scholarshipList) {
		this.scholarshipList = scholarshipList;
	}

	public Boolean getIsForKktc() {
		return isForKktc;
	}

	public void setIsForKktc(Boolean isForKktc) {
		this.isForKktc = isForKktc;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityList == null) ? 0 : cityList.hashCode());
		result = prime * result + ((departmentNameList == null) ? 0 : departmentNameList.hashCode());
		result = prime * result + ((facultyList == null) ? 0 : facultyList.hashCode());
		result = prime * result + ((isEnglish == null) ? 0 : isEnglish.hashCode());
		result = prime * result + ((isForKktc == null) ? 0 : isForKktc.hashCode());
		result = prime * result + ((isMTOK == null) ? 0 : isMTOK.hashCode());
		result = prime * result + ((isNight == null) ? 0 : isNight.hashCode());
		result = prime * result + ((isThereEmptyScape == null) ? 0 : isThereEmptyScape.hashCode());
		result = prime * result + ((maxPointEnd == null) ? 0 : maxPointEnd.hashCode());
		result = prime * result + ((maxPointStart == null) ? 0 : maxPointStart.hashCode());
		result = prime * result + ((minPointEnd == null) ? 0 : minPointEnd.hashCode());
		result = prime * result + ((minPointStart == null) ? 0 : minPointStart.hashCode());
		result = prime * result + ((scholarshipList == null) ? 0 : scholarshipList.hashCode());
		result = prime * result + ((scoreTypeList == null) ? 0 : scoreTypeList.hashCode());
		result = prime * result + ((successSequenceEnd == null) ? 0 : successSequenceEnd.hashCode());
		result = prime * result + ((successSequenceStart == null) ? 0 : successSequenceStart.hashCode());
		result = prime * result + ((topStudentOfSchoolMaxPointEnd == null) ? 0 : topStudentOfSchoolMaxPointEnd.hashCode());
		result = prime * result + ((topStudentOfSchoolMaxPointStart == null) ? 0 : topStudentOfSchoolMaxPointStart.hashCode());
		result = prime * result + ((topStudentOfSchoolMinPointEnd == null) ? 0 : topStudentOfSchoolMinPointEnd.hashCode());
		result = prime * result + ((topStudentOfSchoolMinPointStart == null) ? 0 : topStudentOfSchoolMinPointStart.hashCode());
		result = prime * result + ((universityList == null) ? 0 : universityList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepartmentSearchRequest other = (DepartmentSearchRequest) obj;
		if (cityList == null) {
			if (other.cityList != null)
				return false;
		} else if (!cityList.equals(other.cityList))
			return false;
		if (departmentNameList == null) {
			if (other.departmentNameList != null)
				return false;
		} else if (!departmentNameList.equals(other.departmentNameList))
			return false;
		if (facultyList == null) {
			if (other.facultyList != null)
				return false;
		} else if (!facultyList.equals(other.facultyList))
			return false;
		if (isEnglish == null) {
			if (other.isEnglish != null)
				return false;
		} else if (!isEnglish.equals(other.isEnglish))
			return false;
		if (isForKktc == null) {
			if (other.isForKktc != null)
				return false;
		} else if (!isForKktc.equals(other.isForKktc))
			return false;
		if (isMTOK == null) {
			if (other.isMTOK != null)
				return false;
		} else if (!isMTOK.equals(other.isMTOK))
			return false;
		if (isNight == null) {
			if (other.isNight != null)
				return false;
		} else if (!isNight.equals(other.isNight))
			return false;
		if (isThereEmptyScape == null) {
			if (other.isThereEmptyScape != null)
				return false;
		} else if (!isThereEmptyScape.equals(other.isThereEmptyScape))
			return false;
		if (maxPointEnd == null) {
			if (other.maxPointEnd != null)
				return false;
		} else if (!maxPointEnd.equals(other.maxPointEnd))
			return false;
		if (maxPointStart == null) {
			if (other.maxPointStart != null)
				return false;
		} else if (!maxPointStart.equals(other.maxPointStart))
			return false;
		if (minPointEnd == null) {
			if (other.minPointEnd != null)
				return false;
		} else if (!minPointEnd.equals(other.minPointEnd))
			return false;
		if (minPointStart == null) {
			if (other.minPointStart != null)
				return false;
		} else if (!minPointStart.equals(other.minPointStart))
			return false;
		if (scholarshipList == null) {
			if (other.scholarshipList != null)
				return false;
		} else if (!scholarshipList.equals(other.scholarshipList))
			return false;
		if (scoreTypeList == null) {
			if (other.scoreTypeList != null)
				return false;
		} else if (!scoreTypeList.equals(other.scoreTypeList))
			return false;
		if (successSequenceEnd == null) {
			if (other.successSequenceEnd != null)
				return false;
		} else if (!successSequenceEnd.equals(other.successSequenceEnd))
			return false;
		if (successSequenceStart == null) {
			if (other.successSequenceStart != null)
				return false;
		} else if (!successSequenceStart.equals(other.successSequenceStart))
			return false;
		if (topStudentOfSchoolMaxPointEnd == null) {
			if (other.topStudentOfSchoolMaxPointEnd != null)
				return false;
		} else if (!topStudentOfSchoolMaxPointEnd.equals(other.topStudentOfSchoolMaxPointEnd))
			return false;
		if (topStudentOfSchoolMaxPointStart == null) {
			if (other.topStudentOfSchoolMaxPointStart != null)
				return false;
		} else if (!topStudentOfSchoolMaxPointStart.equals(other.topStudentOfSchoolMaxPointStart))
			return false;
		if (topStudentOfSchoolMinPointEnd == null) {
			if (other.topStudentOfSchoolMinPointEnd != null)
				return false;
		} else if (!topStudentOfSchoolMinPointEnd.equals(other.topStudentOfSchoolMinPointEnd))
			return false;
		if (topStudentOfSchoolMinPointStart == null) {
			if (other.topStudentOfSchoolMinPointStart != null)
				return false;
		} else if (!topStudentOfSchoolMinPointStart.equals(other.topStudentOfSchoolMinPointStart))
			return false;
		if (universityList == null) {
			if (other.universityList != null)
				return false;
		} else if (!universityList.equals(other.universityList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DepartmentSearchRequest [universityList=" + universityList + ", facultyList=" + facultyList + ", departmentNameList=" + departmentNameList + ", isThereEmptyScape=" + isThereEmptyScape
				+ ", scoreTypeList=" + scoreTypeList + ", minPointStart=" + minPointStart + ", minPointEnd=" + minPointEnd + ", maxPointStart=" + maxPointStart + ", maxPointEnd=" + maxPointEnd
				+ ", successSequenceStart=" + successSequenceStart + ", successSequenceEnd=" + successSequenceEnd + ", topStudentOfSchoolMinPointStart=" + topStudentOfSchoolMinPointStart
				+ ", topStudentOfSchoolMinPointEnd=" + topStudentOfSchoolMinPointEnd + ", topStudentOfSchoolMaxPointStart=" + topStudentOfSchoolMaxPointStart + ", topStudentOfSchoolMaxPointEnd="
				+ topStudentOfSchoolMaxPointEnd + ", isNight=" + isNight + ", isEnglish=" + isEnglish + ", isMTOK=" + isMTOK + ", scholarshipList=" + scholarshipList + ", isForKktc=" + isForKktc
				+ ", cityList=" + cityList + "]";
	}

}
