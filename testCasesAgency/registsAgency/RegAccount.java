package registsAgency;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import datasource.BrowsersSet;
import datasource.BrowsersType;
import dosource.NewDo;
import pagesbuilt.InterFRegister;
import pagesbuilt.SimplyHomePage;
import pagesbuilt.SimplyRegisterOnAgency;
import waitsource.wait;
import errormessage.ErrorCode;

public class RegAccount {

	private WebDriver driver;
	private NewDo du;
	private wait wat;

	@BeforeClass
	public void inialize() {
		BrowsersSet browser = new BrowsersSet(BrowsersType.chrome);
		driver = browser.web_driver;
		du = new NewDo(driver);
		wat = new wait(driver);
		driver.manage().window().maximize();
		driver.get(InterFRegister.local);
	}

	
	
}
