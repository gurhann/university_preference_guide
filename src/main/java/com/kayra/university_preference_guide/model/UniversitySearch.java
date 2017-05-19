package com.kayra.university_preference_guide.model;

import java.util.List;

public class UniversitySearch {

	private List<University> universityList;
	private Boolean isPrivate;

	public List<University> getUniversityList() {
		return universityList;
	}

	public void setUniversityList(List<University> universityList) {
		this.universityList = universityList;
	}

	public Boolean getIsPrivate() {
		return isPrivate;
	}

	public void setIsPrivate(Boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isPrivate == null) ? 0 : isPrivate.hashCode());
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
		UniversitySearch other = (UniversitySearch) obj;
		if (isPrivate == null) {
			if (other.isPrivate != null)
				return false;
		} else if (!isPrivate.equals(other.isPrivate))
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
		return "UniversitySearch [universityList=" + universityList + ", isPrivate=" + isPrivate + "]";
	}

}
