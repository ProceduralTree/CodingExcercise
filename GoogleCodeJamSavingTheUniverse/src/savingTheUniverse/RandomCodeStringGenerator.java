package savingTheUniverse;

import java.util.Random;

public class RandomCodeStringGenerator {

	private static String chars = "CS";
	private static Random randomInt = new Random();
	/**
	 * 
	 * @param lenght of generated String
	 * @return random String of "s""c" commands
	 * @requires positive int lenght
	 * @ensures a String of specified length with only C or S chars
	 */
	public static String generate(int lenght) {
		StringBuilder randomString = new StringBuilder();
		for(int i = 0; i < lenght ; i++) {
		randomString.append(chars.charAt(randomInt.nextInt(chars.length())));
		}
		return randomString.toString();
	}
	
}
