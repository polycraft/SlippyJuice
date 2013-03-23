package com.polycraft.slippyjuice.player.info;

public enum Caracteristics {
	SPEED("speed"), HEALTH("health"), VOMIT("vomit"), RESISTANCE("resist");

	private final String code;

	Caracteristics(String code) {
		this.code = code;
	}

	public String code() {
		return code;
	}
}
