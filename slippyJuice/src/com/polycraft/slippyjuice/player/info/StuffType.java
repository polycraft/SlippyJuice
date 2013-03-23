package com.polycraft.slippyjuice.player.info;

public enum StuffType {
	EQUIPMENT("equipment"), ITEM("item");

	private final String code;

	StuffType(String code) {
		this.code = code;
	}

	public String code() {
		return code;
	}
}
