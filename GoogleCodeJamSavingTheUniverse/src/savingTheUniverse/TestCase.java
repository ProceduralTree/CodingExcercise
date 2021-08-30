package savingTheUniverse;

public class TestCase {
	
	 private final String testString;
	private final String expectedResult;
	private final int maxDamage;
	
	public TestCase(String testString, int maxDamage , String expectedResult) {
		this.testString = testString;
		this.expectedResult = expectedResult;
		this.maxDamage = maxDamage;
		
	}

	public String getTestString() {
		return testString;
	}

	public String getExpectedResult() {
		return expectedResult;
	}

	public int getMaxDamage() {
		return maxDamage;
	}
}
