package com.bnp.rover.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RoverConstant {
	
	private RoverConstant() {}
	
	private static final Map<Character, Character> LEFT_MAP;
    static {
    	Map<Character, Character> leftImmuMap = new HashMap<>();
    	leftImmuMap.put('N', 'W');
    	leftImmuMap.put('W', 'S');
    	leftImmuMap.put('S', 'E');
    	leftImmuMap.put('E', 'N');
    	LEFT_MAP = Collections.unmodifiableMap(leftImmuMap);
    }
    
    private static final Map<Character, Character> RIGHT_MAP;
    static {
    	Map<Character, Character> rightImmuMap = new HashMap<>();
    	rightImmuMap.put('N', 'E');
    	rightImmuMap.put('W', 'N');
    	rightImmuMap.put('S', 'W');
    	rightImmuMap.put('E', 'S');
    	RIGHT_MAP = Collections.unmodifiableMap(rightImmuMap);
    }
	
	public static final Map<Character, Map<Character, Character>> DIRECTIONS_MAP;
    static {
    	Map<Character, Map<Character, Character>> dirImmuMap = new HashMap<>();
    	dirImmuMap.put('R', RIGHT_MAP);
    	dirImmuMap.put('L', LEFT_MAP);
    	DIRECTIONS_MAP = Collections.unmodifiableMap(dirImmuMap);
    }
    
    

}
