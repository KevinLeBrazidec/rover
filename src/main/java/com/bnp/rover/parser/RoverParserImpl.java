package com.bnp.rover.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bnp.rover.exception.RoverInitializationException;
import com.bnp.rover.exception.RoverInstructionsException;
import com.bnp.rover.model.Plateau;
import com.bnp.rover.model.RoverImpl;
import com.bnp.rover.util.ParserConstant;


public class RoverParserImpl implements RoverInitializationParser<RoverInitializationException>, InstructionParser<RoverInstructionsException> {
	
	private final String VALID_LINE = "^\\d+ \\d+ [N|E|W|S]$";
	private final String VALID_INSTRUCTIONS = "[LRM]+";
	
	private final int X_PARSE = 0;
	private final int Y_PARSE = 1;
	private final int ORIENTATION_PARSE = 2;

	@Override
	public RoverImpl roverInitializationParse(String line, Plateau plateau) throws RoverInitializationException {
		RoverImpl rover = null;
		if(line != null && line.matches(VALID_LINE)) {
			rover = new RoverImpl(	Integer.parseInt(line.split(ParserConstant.SPACE_SEPARATOR)[X_PARSE]),
									Integer.parseInt(line.split(ParserConstant.SPACE_SEPARATOR)[Y_PARSE]),
									line.split(ParserConstant.SPACE_SEPARATOR)[ORIENTATION_PARSE].charAt(0));
		} else {
			throw new RoverInitializationException("Failed to initialize the rover, the following line is incorrect : " + line);
		}
		
		if(rover != null && (plateau.getBorderTop() < rover.getY() || plateau.getBorderRight() < rover.getX())) {
			throw new RoverInitializationException("Failed to initialize the rover, x or y position is out of the plateau");
		}
		
		return rover;
	}

	@Override
	public List<Character> instructionParse(String instructions) throws RoverInstructionsException {
		List<Character> result = new ArrayList<>();
		if(instructions.matches(VALID_INSTRUCTIONS)) {
			result.addAll(instructions.chars().mapToObj(e -> (char)e).collect(Collectors.toList()));
		} else {
			throw new RoverInstructionsException("Failed to parse instructions, authorized instruction are L,R or M : " + instructions);
		}
		return result;
	}
	
}
