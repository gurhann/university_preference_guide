package com.kayra.university_preference_guide.unit;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.kayra.university_preference_guide.constant.Scholarship;
import com.kayra.university_preference_guide.service.ScholarShipService;
import com.kayra.university_preference_guide.service.imp.ScholarShipServiceImpl;

public class ScholarShipServiceTest {

	public ScholarShipService scholarShipService = new ScholarShipServiceImpl();

	@Test
	public void getScolarShipTypesTest() {
		List<Scholarship> scholarShipTypes = scholarShipService.getScholarShipTypes();
		assertEquals(5, scholarShipTypes.size());
		Scholarship [] values = Scholarship.values();
		for (int i = 0; i < values.length; i++) {
			assertEquals(values[i], scholarShipTypes.get(i));
		}
	}
}
