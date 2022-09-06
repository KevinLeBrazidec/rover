package com.bnp.rover.parser;

import java.util.List;

public interface InstructionParser<T extends Exception> {

	public List<Character> instructionParse(String instructions) throws Exception;
}
