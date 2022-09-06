package com.bnp.rover.parser;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.bnp.rover.exception.PlateauInitializationException;

public class PlateauParserImplTest {
	
	@Test
	public void wrongPlateauInitializationExceptionTest() throws PlateauInitializationException {
		Exception exception = assertThrows(PlateauInitializationException.class, () -> {
			PlateauParserImpl plateauParser = new PlateauParserImpl();
			plateauParser.initializationParse("5 -5");
	    });
		
		String expectedMessage = "Failed to initialize the plateau, the following line is incorrect : ";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
	}

}
