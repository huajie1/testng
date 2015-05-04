package com.testerhome;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SimpleTest {
	
	@Test
	@Parameters({"param1","param2"})
	
	public void parameterTest(String param1,String param2){
		System.out.println(param1+" "+param2);
		
	}

}
