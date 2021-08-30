package savingTheUniverse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RandomCodeStringGeneratorTest {

	@Test
	public void testStringLength() {
		assertEquals(10 , RandomCodeStringGenerator.generate(10).length());
	}
	

}
