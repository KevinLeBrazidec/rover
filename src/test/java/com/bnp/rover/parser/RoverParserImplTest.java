package com.bnp.rover.parser;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.bnp.rover.exception.RoverInitializationException;
import com.bnp.rover.model.Plateau;
import com.bnp.rover.model.RoverImpl;

public class RoverParserImplTest {
	
	Plateau plateau = new Plateau(5,5);
	
	@Test
	public void wrongInstructionsExceptionTest() throws RoverInitializationException {
		Exception exception = assertThrows(RoverInitializationException.class, () -> {
			RoverParserImpl roverParser = new RoverParserImpl();
			RoverImpl rover = roverParser.roverInitializationParse("ZQSD", plateau);
	    });
		
		String expectedMessage = "Failed to initialize the rover, the following line is incorrect : ";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void roverOutOfTheMapExceptionTest() throws RoverInitializationException {
		Exception exception = assertThrows(RoverInitializationException.class, () -> {
			RoverParserImpl roverParser = new RoverParserImpl();
			RoverImpl rover = roverParser.roverInitializationParse("1 7 N", plateau);
	    });
		
		String expectedMessage = "Failed to initialize the rover, x or y position is out of the plateau";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
	}

}
