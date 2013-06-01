package com.polycraft.slippyjuice.pattern;

import java.util.HashMap;
import java.util.Map;

public class PathGenerator {

	private Map<PatternType, Pattern> patterns;
	private PatternType actualPatternType;

	public PathGenerator() {
		this(new HashMap<PatternType, Pattern>());
	}

	public PathGenerator(Map<PatternType, Pattern> patterns) {
		this.patterns = patterns;
		this.actualPatternType = PatternType.NONE;
	}

	/*
	 * Most important method for generating path
	 */
	public void generatePath() {
		Pattern pattern = patterns.get(actualPatternType);

	}

	public void putPattern(PatternType patternType, Pattern pattern) {
		patterns.put(patternType, pattern);
	}
}
