package com.polycraft.slippyjuice.simulation;

// The decorations : hairs, eyes etc...

public enum GameLoopState {
	READY(0), RUNNING(1), PAUSED(2), STOPPED(3);

	private final Integer code;

	GameLoopState(Integer code) {
		this.code = code;
	}

	public Integer state() {
		return code;
	}
}
