package com.polycraft.slippyjuice.stuff;

public enum Caracteristics {
	SPEED("speed"), HEALTH("health"), VOMIT("vomit"), RESISTANCE("resist"), OVERJUICE(
			"overjuice"), WEIGHT("weight");

	private final String code;

	Caracteristics(String code) {
		this.code = code;
	}

	public String code() {
		return code;
	}
}
