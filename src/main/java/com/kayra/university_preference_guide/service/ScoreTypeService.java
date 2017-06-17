package com.kayra.university_preference_guide.service;

import java.util.List;

import com.kayra.university_preference_guide.exception.InfoTypeNullException;
import com.kayra.university_preference_guide.exception.UnknownInfoTypeException;
import com.kayra.university_preference_guide.model.ScoreType;

public interface ScoreTypeService {

	public List<ScoreType> getScoreTypes() throws UnknownInfoTypeException, InfoTypeNullException;
}
