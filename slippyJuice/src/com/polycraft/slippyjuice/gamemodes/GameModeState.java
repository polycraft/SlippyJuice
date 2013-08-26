package com.polycraft.slippyjuice.gamemodes;

// The decorations : hairs, eyes etc...

public enum GameModeState {
	NONE(0), STARTING(1), RUNNING(2), STOPPING(3);

	private final Integer code;

	GameModeState(Integer code) {
		this.code = code;
	}

	public Integer state() {
		return code;
	}
}
