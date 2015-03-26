package ASuites;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.*;
import java.util.*;

import org.testng.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import data_source.BrowersType;
import data_source.browers_set;
import DO_source.DO;
import read_properties.ParseProperties;
import switch_source.Switch;
import wait_source.Wait;;

public class  login  {

	private WebDriver driver;
	private FirefoxProfile firefoxprofile = null;
	private String projectpath = System.getProperty("user.dir");
	private Wait wait = null;
	private DO du;
	
	@BeforeClass
	public void beforeClass() {
		browers_set browser = new browers_set(BrowersType.chrome);
		driver = browser.web_driver;
		du = new DO(driver);
	}
	
	@Test
	public void login()
	{
		driver.get("http://www.piaotai.com");
//		wait.waitForElementIsEnable("//a[text()=\"Æ±Ì¨-¾°ÂÃÍ¨\"]");
//		driver.findElement(By.xpath("//input[@id='name']")).clear();
//		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("gllysleletian");
//	    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("0823letian");
//	    driver.findElement(By.xpath("//button[text()=\"µÇÂ¼\"]")).submit();
        du.what("SearchBox").getText();
	    du.what("string").clear();
	    du.what("string").sendKeys("gllysleletian");
	    du.what("string").sendKeys("0823letian");
	    du.what("string").submit();
	    
	         
	    
	    
		//wait.waitFor(5000);
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	@AfterClass
	public void releaseDriver(){
		driver.close();
	    driver.quit();
	
}
}
