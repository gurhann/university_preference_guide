package com.kayra.university_preference_guide.constant;

public enum Scholarship {
	FULL("(Tam Burslu)"), FIFTY("(%50 Burslu)"), TWENTY_FIVE("(%75 Burslu)"), NO_SCHOLARSHIP("(Ücretli)");

	private String desc;

	private Scholarship(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public static Scholarship getScholarship(String desc) {
		if (desc == null) {
			return null;
		}
		for (Scholarship scholarship : Scholarship.values()) {
			if (desc.equals(scholarship.getDesc())) {
				return scholarship;
			}
		}
		return null;
	}
}
