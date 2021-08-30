package savingTheUniverse;

import java.util.Random;

public class HackingScript {

	public static void main(String[] args) throws IllegalArgumentException {

		String randomString; 
		System.out.println("Testing");
		Random randInt = new Random();
		int maxDamage = 0;
		for(int i = 0 ; i < 10000 ; i++) {
			System.out.print("Case #" + i +":");
			randomString = RandomCodeStringGenerator.generate(30);
			maxDamage =randInt.nextInt(30);
			System.out.println(calcNumberOfHacks(maxDamage,randomString));
		}
	}
	/**
	 * turns a string of commands into array repesentation, where a[i] reprents the amount of shoot "S" comands with i  charge "C" commands infront  
	 * @param cmdString
	 * @return array representation of input
	 * @throws IllegalArgumentException if string contains any character but "S" or "C"
	 */
	public static int[] cmdStringToCmdArray(String cmdString) throws IllegalArgumentException{
		int[] cmdArray = new int[cmdString.length()];
		int k=0;
		for(int i = 0 ; i < cmdString.length() ; i++) {
			if(cmdString.charAt(i) == 'C'){
				k++;
			}else if(cmdString.charAt(i) == 'S') {
				cmdArray[k]++;
			}else {
				throw new IllegalArgumentException();
			}
		}
		return cmdArray;
	}
	/**
	 * calculates damage out of a array representation of an command string 
	 * @param cmdArray
	 * @return int damage
	 */
	public static int calcArrayDamage(int[] cmdArray) {
		int damage = 0;
		int power = 1;
		for(int i = 0; i < cmdArray.length ; i++) {
			damage += cmdArray[i] * power;
			power *= 2;
		}
		return damage;
		
	}
	/**
	 * Simulates hacking procedure using array representation 
	 * @param maxDamage
	 * @param cmdString
	 */
	public static String calcNumberOfHacks(int maxDamage , String cmdString) {
		int numberOfHacks = 0;
		int[] cmdArray = cmdStringToCmdArray(cmdString);
		int damage = calcArrayDamage(cmdArray);
		int highestDamageIndex = cmdArray.length -1;
		String result;
		
		/**
		 * Simulates "S" "C" swaps 
		 * always swaps down one of the "S" with highest individual damage and updates damage accordingly
		 * for further detail see accompanying pdf
		 */
		while(highestDamageIndex > 0 && damage > maxDamage) {
			if(cmdArray[highestDamageIndex] == 0) {
				highestDamageIndex--;
			}else {
				cmdArray[highestDamageIndex]--;
				cmdArray[highestDamageIndex - 1]++;
				numberOfHacks++;
				damage -= (int)Math.pow(2, highestDamageIndex-1);
				
			}
		}
		if(damage <= maxDamage) {
			result = String.valueOf(numberOfHacks);

		}else {
			result = "IMPOSSIBLE";
		}
		return result;
	}
}
