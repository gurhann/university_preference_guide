package com.kayra.university_preference_guide.persistence;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lte;
import static com.mongodb.client.model.Filters.or;
import static com.mongodb.client.model.Filters.where;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.kayra.university_preference_guide.constant.Scholarship;
import com.kayra.university_preference_guide.exception.InfoTypeNullException;
import com.kayra.university_preference_guide.exception.UnknownInfoTypeException;
import com.kayra.university_preference_guide.model.DepartmentSearchRequest;
import com.kayra.university_preference_guide.model.ExtInfoSearchRequest;
import com.kayra.university_preference_guide.model.Faculty;
import com.kayra.university_preference_guide.model.ScoreType;
import com.kayra.university_preference_guide.model.University;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoDriver {
	private static MongoDriver instance;
	private MongoDatabase db;

	@SuppressWarnings("resource")
	private MongoDriver() {
		Properties prop = getProperties();
		db = new MongoClient(prop.getProperty("host"), Integer.parseInt(prop.getProperty("port"))).getDatabase(prop.getProperty("databaseName"));
	}

	public static MongoDriver getInstance() {
		if (instance == null) {
			instance = new MongoDriver();
		}
		return instance;
	}

	private Properties getProperties() {
		Properties prop = new Properties();
		InputStream input = MongoDriver.class.getClassLoader().getResourceAsStream("mongo.properties");
		try {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public List<Document> getExtInfosBy(ExtInfoSearchRequest req) throws UnknownInfoTypeException, InfoTypeNullException {
		if (req.getInfoType() == null) {
			throw new InfoTypeNullException();
		}

		MongoCollection<Document> collection = db.getCollection("ext_infos");
		switch (req.getInfoType()) {
		case CITY:
			return collection.find(new Document("type", "city")).into(new ArrayList<>());
		case SCORE_TYPE:
			return collection.find(new Document("type", "scoreType")).into(new ArrayList<>());
		case FACULTY:
			return collection.find(new Document("type", "faculty")).into(new ArrayList<>());
		case UNIVERSITY:
			break;
		}
		throw new UnknownInfoTypeException();

	}

	public List<Document> getDepartmentBySearchCriteria(DepartmentSearchRequest req) {
		MongoCollection<Document> collection = db.getCollection("departments");

		Bson doc = prepareQuery(req);

		return collection.find(doc).into(new ArrayList<>());
	}

	private Bson prepareQuery(DepartmentSearchRequest req) {

		List<Bson> andParams = new ArrayList<>();
		checkUniversityList(req.getUniversityList(), andParams);
		checkFacultyList(req.getFacultyList(), andParams);
		checkScoreTypeList(req.getScoreTypeList(), andParams);
		checkMinPoints(req.getMinPointStart(), req.getMinPointEnd(), andParams);
		checkMaxPoints(req.getMaxPointStart(), req.getMaxPointEnd(), andParams);
		checkSuccessSequence(req.getSuccessSequenceStart(), req.getSuccessSequenceEnd(), andParams);
		checkTopStudentOfSchoolMinPoint(req.getTopStudentOfSchoolMinPointStart(), req.getTopStudentOfSchoolMinPointEnd(), andParams);
		checkTopStudentOfSchoolMaxPoint(req.getTopStudentOfSchoolMaxPointStart(), req.getTopStudentOfSchoolMaxPointEnd(), andParams);
		checkIsEnglish(req.getIsEnglish(), andParams);
		checkIsForKKTC(req.getIsForKktc(), andParams);
		checkIsMTOK(req.getIsMTOK(), andParams);
		checkIsNight(req.getIsNight(), andParams);
		checkScholarShip(req.getScholarshipList(), andParams);
		checkEmptySpace(req.getIsThereEmptyScape(), andParams);
		return Filters.and((Iterable<Bson>) andParams);
	}

	private void checkUniversityList(List<University> universityList, List<Bson> andParams) {
		if (CollectionUtils.isNotEmpty(universityList)) {

			List<Bson> universityDocList = new ArrayList<>();
			for (University university : universityList) {
				Document universityDoc = new Document();
				universityDoc.append("university.name", university.getName());
				universityDocList.add(universityDoc);
			}

			andParams.add(or((Iterable<Bson>) universityDocList));
		}
	}

	private void checkFacultyList(List<Faculty> facultyList, List<Bson> andParams) {
		if (CollectionUtils.isNotEmpty(facultyList)) {

			List<Bson> facultyDocList = new ArrayList<>();
			for (Faculty faculty : facultyList) {
				Document facultyDoc = new Document();
				facultyDoc.append("faculty_name", faculty.getName());
				facultyDocList.add(facultyDoc);
			}

			andParams.add(or((Iterable<Bson>) facultyDocList));
		}
	}

	private void checkScoreTypeList(List<ScoreType> scoreTypes, List<Bson> andParams) {
		if (CollectionUtils.isNotEmpty(scoreTypes)) {

			List<Bson> scoreTypesDocList = new ArrayList<>();
			for (ScoreType scoreType : scoreTypes) {
				Document scoreTypeDoc = new Document();
				scoreTypeDoc.append("score_type", scoreType.getName());
				scoreTypesDocList.add(scoreTypeDoc);
			}

			andParams.add(or((Iterable<Bson>) scoreTypesDocList));
		}
	}

	private void checkMinPoints(Double minPointStart, Double minPointEnd, List<Bson> andParams) {
		if (ObjectUtils.anyNotNull(minPointStart, minPointEnd)) {
			andParams.add(and(gte("min_point", minPointStart), lte("min_point", minPointEnd)));
		}
	}

	private void checkMaxPoints(Double maxPointStart, Double maxPointEnd, List<Bson> andParams) {
		if (ObjectUtils.anyNotNull(maxPointStart, maxPointEnd)) {
			andParams.add(and(gte("max_point", maxPointStart), lte("max_point", maxPointEnd)));
		}
	}

	private void checkSuccessSequence(Integer succesSequenceStart, Integer succesSequenceEnd, List<Bson> andParams) {
		if (ObjectUtils.anyNotNull(succesSequenceStart, succesSequenceEnd)) {
			andParams.add(and(gte("succes_sequence", succesSequenceStart), lte("succes_sequence", succesSequenceEnd)));

		}
	}

	private void checkTopStudentOfSchoolMinPoint(Double topStudentOfSchoolMinPointStart, Double topStudentOfSchoolMinPointEnd, List<Bson> andParams) {
		if (ObjectUtils.anyNotNull(topStudentOfSchoolMinPointStart, topStudentOfSchoolMinPointEnd)) {
			andParams.add(and(gte("top_students_of_school_min_point", topStudentOfSchoolMinPointStart), lte("top_students_of_school_min_point", topStudentOfSchoolMinPointEnd)));

		}
	}

	private void checkTopStudentOfSchoolMaxPoint(Double topStudentOfSchoolmaxPointStart, Double topStudentOfSchoolmaxPointEnd, List<Bson> andParams) {
		if (ObjectUtils.anyNotNull(topStudentOfSchoolmaxPointStart, topStudentOfSchoolmaxPointEnd)) {
			andParams.add(and(gte("top_students_of_school_max_point", topStudentOfSchoolmaxPointStart), lte("top_students_of_school_max_point", topStudentOfSchoolmaxPointEnd)));

		}
	}

	private void checkIsNight(Boolean isNight, List<Bson> andParams) {
		if (ObjectUtils.anyNotNull(isNight)) {
			andParams.add(new Document("is_night", isNight));
		}
	}

	private void checkIsMTOK(Boolean isMTOK, List<Bson> andParams) {
		if (ObjectUtils.anyNotNull(isMTOK)) {
			andParams.add(new Document("is_mtok", isMTOK));

		}
	}

	private void checkIsEnglish(Boolean isEnglish, List<Bson> andParams) {
		if (ObjectUtils.anyNotNull(isEnglish)) {
			andParams.add(new Document("is_english", isEnglish));

		}
	}

	private void checkScholarShip(List<Scholarship> scholarShipList, List<Bson> andParams) {
		if (CollectionUtils.isNotEmpty(scholarShipList)) {

			List<Bson> scholarshipDocList = new ArrayList<>();
			for (Scholarship scholarship : scholarShipList) {
				Document scholarshipDoc = new Document();
				scholarshipDoc.append("scholarship", scholarship.getDesc());
				scholarshipDocList.add(scholarshipDoc);
			}

			andParams.add(or((Iterable<Bson>) scholarshipDocList));
		}
	}

	private void checkIsForKKTC(Boolean isForKKTC, List<Bson> andParams) {
		if (ObjectUtils.anyNotNull(isForKKTC)) {
			andParams.add(new Document("is_for_kktc", isForKKTC));

		}
	}

	private void checkEmptySpace(Boolean emptySpace, List<Bson> andParams) {
		if (BooleanUtils.isTrue(emptySpace)) {
			andParams.add(where("this.quota > this.settled"));
		}
	}

}
