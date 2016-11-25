package sadowski;

import java.util.ArrayList;
import java.util.Arrays;

public class Util {
	static String[] splitByWhitespace(String s) {
		return s.split("\\s+");
	}

	static Double[] convertStringsToDoubles(String[] strings) {
		ArrayList<Double> toReturn = new ArrayList<Double>();
		for (String s : strings) {
			toReturn.add(Double.parseDouble(s));
		}
		return toReturn.toArray(new Double[0]);
	}

	static ArrayList<String> convertDoublesToStrings(Double[] doubles) {
		ArrayList<String> toReturn = new ArrayList<String>();
		for (Double d : doubles) {
			toReturn.add(d + "");
		}
		return toReturn;
	}
	
	public static void printArrayList(ArrayList<String> list) {
		System.out.println(Arrays.toString(list.toArray(new String[0])));
	}
	
	public static String mergeArrayListOfStrings(ArrayList<String> lines) {
		String merged = "";
		for (String s : lines) {
			merged += s;
			merged += " ";
		}
		return merged;
	}
}
