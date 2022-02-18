package test;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class Testing{
	@Test
	public void MavenParameterTest(){
		String state = System.getProperty("execution","correct");
		
		assertEquals("correct", state);
	}
}