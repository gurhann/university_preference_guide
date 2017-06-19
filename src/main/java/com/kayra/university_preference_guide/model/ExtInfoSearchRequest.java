package com.kayra.university_preference_guide.model;

import com.kayra.university_preference_guide.constant.InfoType;

public class ExtInfoSearchRequest {

	private InfoType infoType;
	private ExtInfoSearch searchCriteria;

	public ExtInfoSearchRequest(InfoType infoType) {
		this.infoType = infoType;
	}

	public InfoType getInfoType() {
		return infoType;
	}

	public void setInfoType(InfoType infoType) {
		this.infoType = infoType;
	}

	public ExtInfoSearch getSearchCriteria() {
		return searchCriteria;
	}

	public void setSearchCriteria(ExtInfoSearch searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((infoType == null) ? 0 : infoType.hashCode());
		result = prime * result + ((searchCriteria == null) ? 0 : searchCriteria.hashCode());
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
		ExtInfoSearchRequest other = (ExtInfoSearchRequest) obj;
		if (infoType != other.infoType)
			return false;
		if (searchCriteria == null) {
			if (other.searchCriteria != null)
				return false;
		} else if (!searchCriteria.equals(other.searchCriteria))
			return false;
		return true;
	}
	
	

}
