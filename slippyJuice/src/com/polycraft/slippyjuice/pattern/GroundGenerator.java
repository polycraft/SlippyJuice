package com.polycraft.slippyjuice.pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.polycraft.slippyjuice.assets.SlippyJuiceAssets;
import com.polycraft.slippyjuice.scene.ground.GroundPiece;

public class GroundGenerator {

	private AssetManager assetManager;
	private int nbGroundLines;
	private int nbGroundColumn;

	private static int minPieces = 64;
	private static int maxPieces = 200;

	private Map<PatternType, List<String>> patterns;
	private PatternType actualPatternType;

	public GroundGenerator(AssetManager assetManager, int nbGroundLines,
			int nbGroundColumn) {
		this(assetManager, nbGroundLines, nbGroundColumn,
				new HashMap<PatternType, List<String>>());
	}

	public GroundGenerator(AssetManager assetManager, int nbGroundLines,
			int nbGroundColumn, Map<PatternType, List<String>> patterns) {
		this.patterns = patterns;
		this.actualPatternType = PatternType.NONE;
		this.nbGroundLines = nbGroundLines;
		this.nbGroundColumn = nbGroundColumn;
		this.assetManager = assetManager;
	}

	/*
	 * Most important method for generating path
	 */
	public List<GroundPiece> generatePath() {
		List<GroundPiece> pathList = new ArrayList<GroundPiece>();

		int nbPieces = MathUtils.random(minPieces, maxPieces);
		// divisible par nblignes;
		int nbPiecesToDelete = (nbPieces % nbGroundLines);

		nbPieces -= nbPiecesToDelete;

		for (int i = 0; i < nbPieces; i++) {
			GroundPiece piece = new GroundPiece(assetManager.get(
					SlippyJuiceAssets.getPath("groundPiece"), Texture.class));
			pathList.add(piece);
		}

		return pathList;
	}

	public void putPattern(PatternType patternType, List<String> pattern) {
		patterns.put(patternType, pattern);
	}
}
