package com.bnp.rover.parser;

import com.bnp.rover.model.Plateau;
import com.bnp.rover.model.RoverImpl;

public interface RoverInitializationParser<T extends Exception> {
	
	public RoverImpl roverInitializationParse(String line, Plateau plateau) throws Exception;

}
