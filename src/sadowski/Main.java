package sadowski;

import java.io.IOException;
import java.util.ArrayList;

import sadowski.ArgsChecker;

public class Main {
	Calculator calc = new Calculator();
	
	ArrayList<String> run(String[] args) throws TooFewArguments, IOException {
		ArrayList<String> lines = null;
		ArrayList<String> results = new ArrayList<String>();
		
		try {
			ArgsChecker.checkLessArgsThanOne(args);
		} catch (TooFewArguments e) {
			System.err.println("Too few arguments from command line PROVIDED!");
		}
		
		String inputPath = args[0];
		String outputPath = args[1];
		
		if(FileReader.fileExists(inputPath)) {
			lines = FileReader.readLines(inputPath);
		}
		
		for(String s : lines) {
			String[] strFactors = Util.splitByWhitespace(s);
			if(strFactors.length!=3) {
				results.add("Wrong amount of factors!");
				continue;
			}
			Double[] factors = null;
			try {
				factors = Util.convertStringsToDoubles(strFactors);
			} catch (NumberFormatException e) {
				results.add("Incorrect input value...");
				continue;
			}
			
			Double[] roots = calc.getTrinomialRoots(factors[0], factors[1], factors[2]);
			
			if(roots!=null)
				results.add( Util.mergeArrayListOfStrings( Util.convertDoublesToStrings(roots) ) );
			else
				results.add("No real roots...");
		}
		
		FileWriter.writeLinesAndShowMapping(outputPath, results.toArray(new String[0]), lines.toArray(new String[0]), "   --->   ");
		return results;
	}
	
	public static void main(String[] args) throws TooFewArguments, IOException {
		Main m = new Main();
		m.run(args);
	}
}
