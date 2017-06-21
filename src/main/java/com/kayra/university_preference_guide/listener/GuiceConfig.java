package com.kayra.university_preference_guide.listener;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.kayra.university_preference_guide.persistence.MongoDriver;
import com.kayra.university_preference_guide.service.CityService;
import com.kayra.university_preference_guide.service.DepartmentService;
import com.kayra.university_preference_guide.service.FacultyService;
import com.kayra.university_preference_guide.service.ScholarShipService;
import com.kayra.university_preference_guide.service.ScoreTypeService;
import com.kayra.university_preference_guide.service.UniversityService;
import com.kayra.university_preference_guide.service.imp.CityServiceImpl;
import com.kayra.university_preference_guide.service.imp.DepartmentServiceImpl;
import com.kayra.university_preference_guide.service.imp.FacultyServiceImpl;
import com.kayra.university_preference_guide.service.imp.ScholarShipServiceImpl;
import com.kayra.university_preference_guide.service.imp.ScoreTypeServiceImpl;
import com.kayra.university_preference_guide.service.imp.UniversityServiceImpl;
import com.squarespace.jersey2.guice.JerseyGuiceModule;
import com.squarespace.jersey2.guice.JerseyGuiceUtils;

public class GuiceConfig extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		List<Module> modules = new ArrayList<Module>();
		modules.add(new JerseyGuiceModule("__HK2_Generated_0"));
		modules.add(new ServletModule() {
			@Override
			protected void configureServlets() {
				bind(CityService.class).to(CityServiceImpl.class);
				bind(DepartmentService.class).to(DepartmentServiceImpl.class);
				bind(FacultyService.class).to(FacultyServiceImpl.class);
				bind(ScholarShipService.class).to(ScholarShipServiceImpl.class);
				bind(UniversityService.class).to(UniversityServiceImpl.class);
				bind(ScoreTypeService.class).to(ScoreTypeServiceImpl.class);
				bind(MongoDriver.class);

			}
		});
		Injector injector = Guice.createInjector(modules);
		JerseyGuiceUtils.install(injector);
		return injector;
	}

}
