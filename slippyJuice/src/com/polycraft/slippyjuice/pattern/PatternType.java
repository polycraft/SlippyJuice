package com.polycraft.slippyjuice.pattern;

public enum PatternType {
	NONE("none"), CITY("city"), MOUNTAINS("mountains"), HILLS("hills");

	private final String code;

	PatternType(String code) {
		this.code = code;
	}

	public String code() {
		return code;
	}
}
