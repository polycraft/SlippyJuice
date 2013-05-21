package com.polycraft.slippyjuice.player;

public enum Caracteristics {
	SPEED("speed"), ACCELERATION("acceleration"), HEALTH("health"), VOMIT(
			"vomit"), RESISTANCE("resist"), OVERJUICE("overjuice"), WEIGHT(
			"weight");

	private final String code;

	Caracteristics(String code) {
		this.code = code;
	}

	public String code() {
		return code;
	}
}
