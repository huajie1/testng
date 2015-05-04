package com.testerhome;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import junit.framework.Assert;

public class loginAndExitTest{
  private FirefoxDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();
 
  @BeforeTest
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://testerhome.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLogin() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.xpath("//a[text()='µÇÂ¼']")).click();
    driver.findElement(By.xpath("//input[@id='user_login']")).clear();
    driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("ÄãµÄÕÊºÅ");
    driver.findElement(By.xpath("//input[@id='user_password']")).clear();
    driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("ÄãµÄÃÜÂë");
    driver.findElement(By.name("commit")).click();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
    driver.findElement(By.xpath("//*[text()='ÍË³ö']")).click();
    //driver.findElement(By.xpath("//a[starts-with(@rel,'nofo')]")).click();
    //driver.findElement(By.xpath("//a[contains(text(),'ÍË³ö'])")).click();
    //driver.findElement(By.xpath("//a[contains(@href,'sign_out')]")).click();
      
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      Assert.fail(verificationErrorString);
    }
  }

}
