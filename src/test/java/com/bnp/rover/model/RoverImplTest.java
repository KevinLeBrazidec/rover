package com.bnp.rover.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.bnp.rover.exception.RoverInitializationException;
import com.bnp.rover.exception.RoverInstructionsException;
import com.bnp.rover.parser.RoverParserImpl;

public class RoverImplTest {
	
	Plateau plateau = new Plateau(5,5);
	RoverParserImpl roverParser = new RoverParserImpl();
	
	@Test
	public void turnLeftTest() throws RoverInitializationException {
		RoverImpl rover = roverParser.roverInitializationParse("1 2 N", plateau);
		rover.rotate('L');
		assertEquals(rover.getOrientation(), 'W');
	}
	
	@Test
	public void turnRightTest() throws RoverInitializationException {
		RoverImpl rover = roverParser.roverInitializationParse("1 2 N", plateau);
		rover.rotate('R');
		assertEquals(rover.getOrientation(), 'E');
	}
	
	@Test
	public void moveOutOfLeftBorderTest() throws RoverInitializationException {
		RoverImpl rover = roverParser.roverInitializationParse("0 0 W", plateau);
		rover.move(plateau);
		assertEquals(rover.getX(), 0);
	}
	
	@Test
	public void moveOutOfBottomBorderTest() throws RoverInitializationException {
		RoverImpl rover = roverParser.roverInitializationParse("0 0 S", plateau);
		rover.move(plateau);
		assertEquals(rover.getY(), 0);
	}
	
	@Test
	public void moveOutOfTopBorderTest() throws RoverInitializationException {
		RoverImpl rover = roverParser.roverInitializationParse("5 5 N", plateau);
		rover.move(plateau);
		assertEquals(rover.getY(), 5);
	}
	
	@Test
	public void moveOutOfTopRightTest() throws RoverInitializationException {
		RoverImpl rover = roverParser.roverInitializationParse("5 5 E", plateau);
		rover.move(plateau);
		assertEquals(rover.getX(), 5);
	}
	
	@Test
	public void fullPathTest() throws RoverInitializationException, RoverInstructionsException {
		RoverImpl rover = roverParser.roverInitializationParse("1 2 N", plateau);
		List<Character> instructions = roverParser.instructionParse("LMLMLMLMM");
		instructions.stream().forEach(inst -> {
			if(inst == 'M') {
				rover.move(plateau);
			} else {
				rover.rotate(inst);
			}
		});
		assertEquals(rover.toString(), "1 3 N\n");
	}

}
