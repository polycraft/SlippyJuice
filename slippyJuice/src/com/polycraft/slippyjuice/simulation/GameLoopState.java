package com.polycraft.slippyjuice.simulation;

// The decorations : hairs, eyes etc...

public enum GameLoopState {
	CREATED(0), START(1), RUN(2), PAUSED(3), STOPPED(4);

	private final Integer code;

	GameLoopState(Integer code) {
		this.code = code;
	}

	public Integer state() {
		return code;
	}
}
