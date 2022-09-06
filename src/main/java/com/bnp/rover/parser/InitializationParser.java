package com.bnp.rover.parser;

public interface InitializationParser<T, E extends Exception> {
	
	public T initializationParse(String line) throws Exception;

}
