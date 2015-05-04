package com.testerhome;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

	private FirefoxDriver driver;

	@Parameters({"browser"})
	@BeforeTest
	public void openBrowser(String browser) {
		driver = new FirefoxDriver();
	}

	@Parameters({"baseurl", "keyword" })
	@Test
	public void search(String baseurl, String keyword){
		
		driver.get(baseurl);	
		WebElement element = driver.findElementByXPath("//input[@id='kw']");
		element.sendKeys(keyword);
		element.submit();
		Assert.assertTrue(driver.getTitle().contains(keyword));
	}
}