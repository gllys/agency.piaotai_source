package loginagency;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;


import org.testng.annotations.Test;

import pagesbuilt.InterFRegister;
import datasource.BrowsersSet;
import datasource.BrowsersType;
import dosource.NewDo;
import waitsource.*;

public class LoginAgency {

	private WebDriver driver;
	private NewDo du;
	private wait wat;

	@BeforeClass
	public void loginInialize() {

		BrowsersSet browser = new BrowsersSet(BrowsersType.chrome);
		driver = browser.web_driver;
		du = new NewDo(driver);
		wat = new wait(driver);
		driver.manage().window().maximize();
        
	}
          //du.whats("//div[@class='nav-inner']/a").toArray();
	@Test
	public void checkValue(){
		driver.get(InterFRegister.local);
		wat.waitForElementPresent(InterFRegister.dashpicture);
		int titlenum = 6;
		int realtitlenum = Integer.valueOf(du.whats(InterFRegister.dashtitle).size());
		Assert.assertEquals(titlenum, realtitlenum);
	}	
	
	@Test
	public void checkSix(){

	    WebElement alltitlename = driver.findElement(By.xpath("//div[@class='nav-inner']//a[@href][1]"));
		System.out.println(alltitlename);
//		for(WebElement eachtitlename:alltitlename)
//		   System.out.println(eachtitlename);
	}
	
}
