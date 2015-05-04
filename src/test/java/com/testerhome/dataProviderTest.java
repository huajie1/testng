package com.testerhome;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


	public class DataProviderTest {
	    
	    private FirefoxDriver driver;
	    
	    @BeforeTest
	    @Parameters("baseurl")
	    public void setUp(String baseurl){
			driver = new FirefoxDriver();
			driver.get(baseurl);	    	
	    	
	    }
	    
		@DataProvider(name="dataTest")
	    public Object[][] createData(){
	        return new Object[][]{
	        		{"testng","TestNG"},
	        };
	    }
		
	    @Test(dataProvider="dataTest")
	    public void search(String input,String output){  	
			WebElement element = driver.findElementByXPath("//input[@id='kw']");
			element.sendKeys(input);
			element.submit();
			Assert.assertTrue(driver.getPageSource().contains(output));
	    }
	}
