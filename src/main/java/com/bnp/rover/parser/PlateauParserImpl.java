package com.bnp.rover.parser;

import com.bnp.rover.exception.PlateauInitializationException;
import com.bnp.rover.model.Plateau;
import com.bnp.rover.util.ParserConstant;

public class PlateauParserImpl implements InitializationParser<Plateau, PlateauInitializationException> {
	
	private final String FIELD_VALID_LINE = "^\\d+ \\d+$";
	private final int FIELD_RIGHT_BORDER_PARSE = 0;
	private final int FIELD_TOP_BORDER_PARSE = 1;

	@Override
	public Plateau initializationParse(String line) throws PlateauInitializationException {
		Plateau plateau = null;
		
		if(line!= null && line.matches(FIELD_VALID_LINE)) {
			plateau = new Plateau(	Integer.parseInt(line.split(ParserConstant.SPACE_SEPARATOR)[FIELD_RIGHT_BORDER_PARSE]),
									Integer.parseInt(line.split(ParserConstant.SPACE_SEPARATOR)[FIELD_TOP_BORDER_PARSE]));

		} else {
			throw new PlateauInitializationException("Failed to initialize the plateau, the following line is incorrect : " + line);
		}
		return plateau;
	}

}
