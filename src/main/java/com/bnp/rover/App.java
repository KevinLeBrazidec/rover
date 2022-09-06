package com.bnp.rover;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bnp.rover.exception.PlateauInitializationException;
import com.bnp.rover.exception.RoverInitializationException;
import com.bnp.rover.exception.RoverInstructionsException;
import com.bnp.rover.model.Plateau;
import com.bnp.rover.model.RoverImpl;
import com.bnp.rover.parser.PlateauParserImpl;
import com.bnp.rover.parser.RoverParserImpl;
import com.bnp.rover.util.AppLogger;

public class App 
{
	public static void main( String[] args )
	{
		String result = "";
		PlateauParserImpl plateauParser = new PlateauParserImpl();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(args[0]));
			Plateau plateau = scanner.hasNextLine() ? plateauParser.initializationParse(scanner.nextLine()) : null;
			result = runRover(scanner, plateau);
		} catch (FileNotFoundException | PlateauInitializationException e) {
			AppLogger.logger.error(e);
		} finally {
			if(scanner != null) scanner.close();
		}
		System.out.println(result);
	}
	
	public static String runRover(Scanner scanner, Plateau plateau) {
		String result = "";
		List<Character> instructions = new ArrayList<>();
		RoverParserImpl roverParser = new RoverParserImpl();
		while(scanner.hasNextLine()) {
			try {
				RoverImpl rover = roverParser.roverInitializationParse(scanner.nextLine(), plateau);
				instructions = roverParser.instructionParse(scanner.nextLine());
				instructions.stream().forEach(inst -> {
					if(inst == 'M') {
						rover.move(plateau);
					} else {
						rover.rotate(inst);
					}
				});
				result += rover.toString();
			} catch (RoverInitializationException e) {
				if(scanner.hasNextLine()) {
					scanner.nextLine();
				}
				AppLogger.logger.error(e);
			} catch (RoverInstructionsException e) {
				AppLogger.logger.error(e);
			}
		}
		return result;
	}
}
