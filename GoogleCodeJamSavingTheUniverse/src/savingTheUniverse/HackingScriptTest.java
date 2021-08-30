package savingTheUniverse;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;



public class HackingScriptTest {
	
	@Test
	public void testCalcArrayDamage() {
		int[] testArray = new int[] {1,0,3,8,2,0,0,0};
		int expectedDamage = 109;
		int actualDamage = HackingScript.calcArrayDamage(testArray);
		assertEquals(expectedDamage , actualDamage);
	}
	@Test
	public void testCmdStringToCmdArray() {
		String testString = "SCSCCSCSSSCCSCCSC";
		int[] expectedArray  = new int[] {1,1,0,1,3,0,1,0,1,0,0,0,0,0,0,0,0};
		int[] actualArray = HackingScript.cmdStringToCmdArray(testString);
		assertArrayEquals(expectedArray , actualArray);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testArrayConversionExeption() {
	String testString = "CSCSSSDCS";
	HackingScript.cmdStringToCmdArray(testString);
	}
	
	@Test
	public void testHackingScript(){

	 ArrayList<TestCase> testCases = new ArrayList<TestCase>();
	 testCases.add(new TestCase("CS",1, "1"));
	 testCases.add(new TestCase("CS",2, "0"));
	 testCases.add(new TestCase("SS",1, "IMPOSSIBLE"));
	 testCases.add(new TestCase("SCCSSC",6, "2"));
	 testCases.add(new TestCase("CC",2, "0"));
	 testCases.add(new TestCase("CSCSS",3, "5"));
	 
	 for(TestCase t : testCases) {
		 String actual = HackingScript.calcNumberOfHacks(t.getMaxDamage(), t.getTestString());
		 assertEquals(t.getExpectedResult() , actual);
	 }

	}
}
