package asuites;

/**
 * 登录前置
 * @author gllys
 */
import org.openqa.selenium.WebDriver;

import datasource.BrowsersSet;
import datasource.BrowsersType;
import dosource.NewDo;
import pagesbuilt.InterFRegister;
import waitsource.wait;
import errormessage.ErrorCode;

public class agencyLogin {

	static private WebDriver driver;
	static private NewDo du;
	static private wait wat;

	public static void inialize() {

		BrowsersSet browser = new BrowsersSet(BrowsersType.chrome);
		driver = browser.web_driver;
		du = new NewDo(driver);
		wat = new wait(driver);
		// action = new Actions(driver);
		driver.manage().window().maximize();
		driver.get(InterFRegister.local);

		wat.waitForElementPresent(InterFRegister.dashpicture);
		try {
			du.what(InterFRegister.useraccount).sendKeys(
					InterFRegister.useraccountnumber);
			du.what(InterFRegister.userpassword).sendKeys(
					InterFRegister.userpasswordnumber);
			du.what(InterFRegister.userloginbtn).click();
		} catch (Exception e) {
			System.out.println(e + ErrorCode.nosource);
		}
	}
	public static void getout (){
	driver.close();
	driver.quit();
	}
}
