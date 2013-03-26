package com.polycraft.slippyjuice.player;

public class PlayerInformation {
	private String playername;
	private Integer coins;
	private Integer level;

	public PlayerInformation(String playername) {
		this(playername, 0, 1);
	}

	public PlayerInformation(String playerName, Integer coins, Integer level) {
		this.playername = playerName;
		this.coins = coins;
		this.level = level;

	}

	public String getPlayername() {
		return playername;
	}

	public Integer getCoins() {
		return coins;
	}

	public void setPlayername(String playername) {
		this.playername = playername;
	}

	public void setCoins(Integer coins) {
		this.coins = coins;
	}

	public Integer getLevel() {
		return level;
	}

	public String toString() {
		return playername + "(" + coins + "$), level " + level;
	}
}
