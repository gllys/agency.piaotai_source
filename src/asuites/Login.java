package asuites;

import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.Wait;

import datasource.BrowsersType;
import datasource.BrowsersSet;
import dosource.Do;
import waitsource.*;


public class  Login  {

	private WebDriver driver;
	private Do du;

	
	@BeforeClass
	public void beforeClass() {
		BrowsersSet browser = new BrowsersSet(BrowsersType.chrome);
		driver = browser.web_driver;
		du = new Do(driver);
	}
	
	@Test
	public void login()
	{
		driver.get("http://www.piaotai.com");
	    du.what("string").clear();
	    du.what("string").sendKeys("gllysleletian");
	    du.what("string").sendKeys("0823letian");
	    du.what("string").submit();
	    du.waitFor(2000);
	}
	
	@Test/*(dependsOnMethods={"login"}) */
	public void checkLg(){
		int serfacrNum = 0;
		int totalNum = 0;
		String strNum = du.what("Num").getText();
		int unreadNumLift = Integer.valueOf(strNum); 
		
		du.what("string").click();
		du.waitForElementPresent("string");
		du.waitFor(1000);
		du.what("string").click();
		du.waitForElementPresent("string");
		
		totalNum = Integer.valueOf(du.what("string").getText()); 
	    
		while(totalNum>=1){
			serfacrNum = serfacrNum + du.whats("string").size();
			
			try {
				du.what("string").click();
				du.waitFor(2000);
				
			} catch (Exception e) {
				break;
				// TODO: handle exception
			}
			totalNum--;
		}
		System.out.println("1--------------"+unreadNumLift);
		System.out.println("2--------------"+serfacrNum);
				
	}

	
	@AfterClass
	public void releaseDriver(){
		driver.close();
	    driver.quit();
	
}
}
