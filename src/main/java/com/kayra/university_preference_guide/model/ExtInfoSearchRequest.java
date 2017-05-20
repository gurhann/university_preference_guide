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

}
