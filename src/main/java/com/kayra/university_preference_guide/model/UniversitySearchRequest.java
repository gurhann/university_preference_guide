package com.kayra.university_preference_guide.model;

import java.util.List;

public class UniversitySearchRequest implements ExtInfoSearch {

	private List<City> cityList;
	private Boolean isPrivate;

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
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
		result = prime * result + ((cityList == null) ? 0 : cityList.hashCode());
		result = prime * result + ((isPrivate == null) ? 0 : isPrivate.hashCode());
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
		UniversitySearchRequest other = (UniversitySearchRequest) obj;
		if (cityList == null) {
			if (other.cityList != null)
				return false;
		} else if (!cityList.equals(other.cityList))
			return false;
		if (isPrivate == null) {
			if (other.isPrivate != null)
				return false;
		} else if (!isPrivate.equals(other.isPrivate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UniversitySearchRequest [cityList=" + cityList + ", isPrivate=" + isPrivate + "]";
	}

}
