package com.kayra.university_preference_guide.util;

public class DeploymentUtils {

	public static boolean isDeployedToHeroku() {
		String isDeployedToHeroku = System.getenv("isDeployedToHeroku");
		return isDeployedToHeroku != null && "true".equals(isDeployedToHeroku);
	}
}
