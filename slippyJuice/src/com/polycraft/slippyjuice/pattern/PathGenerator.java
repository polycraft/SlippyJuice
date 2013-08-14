package com.polycraft.slippyjuice.pattern;

import java.util.HashMap;
import java.util.Map;

public class PathGenerator {

	private Map<PatternType, GroundPattern> patterns;
	private PatternType actualPatternType;

	public PathGenerator() {
		this(new HashMap<PatternType, GroundPattern>());
	}

	public PathGenerator(Map<PatternType, GroundPattern> patterns) {
		this.patterns = patterns;
		this.actualPatternType = PatternType.NONE;
	}

	/*
	 * Most important method for generating path
	 */
	public void generatePath() {
		GroundPattern pattern = patterns.get(actualPatternType);
	}

	public void putPattern(PatternType patternType, GroundPattern pattern) {
		patterns.put(patternType, pattern);
	}
}
