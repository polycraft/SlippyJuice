package com.polycraft.slippyjuice.player;

public enum Properties {
	SPEED("speed"), ACCELERATION("acceleration"), HEALTH("health"), FRICTION(
			"friction"), VOMIT("vomit"), DEFENCE("defence"), OVERJUICE(
			"overjuice"), WEIGHT("weight");

	private final String code;

	Properties(String code) {
		this.code = code;
	}

	public String code() {
		return code;
	}
}
