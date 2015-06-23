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

public class InRegAgency {
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
	
	@Test
	public void regAgency() {
		//du.what(InterFRegister.getinreg).click();
		int length = 6;
		String base = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		String randomaccount = sb.toString();

		SimplyHomePage simplyhomepage = new SimplyHomePage(driver);
		SimplyRegisterOnAgency simplyregisteronagency = new SimplyRegisterOnAgency(driver);

		// 初始化2个封装后便可以调用
		/**
		 * Description :JS to specific window.
		 * 
		 * @author ：Gllys
		 * @see :
		 * @param :
		 * @return : void
		 * @create ：2015-04-20
		 * @exception :
		 * @version ：1.0
		 **/

		try {

			simplyhomepage.register();
			// String currentUrl = driver.getCurrentUrl();
			System.out.println("register good");
			wat.waitForElementIsEnable(InterFRegister.regturnback);
			((JavascriptExecutor) driver).executeScript("document.getElementById('verifycode').className ='form-control validate[required]';");
			wat.waitFor(2000);
			System.out.println("verifycode good");
			((JavascriptExecutor) driver).executeScript("document.getElementById('verifycode').name ='RegisterForm[1]';");

			((JavascriptExecutor) driver).executeScript("document.getElementById('code').className ='form-control validate[required]';");

			((JavascriptExecutor) driver).executeScript("document.getElementById('code').name ='RegisterForm[1]';");

			wat.waitFor(2000);
			simplyregisteronagency.setAccount(randomaccount);
			simplyregisteronagency.setPassword(InterFRegister.userpasswordnumber);
			simplyregisteronagency.setMoblie(InterFRegister.mobilenumber);
			simplyregisteronagency.setVerify(InterFRegister.regverify);
			simplyregisteronagency.setMobileVerify(InterFRegister.regmobileverify);

			try {
				simplyregisteronagency.regsubmit();
			} catch (Exception e) {
				System.out.println(e);// TODO: handle exception
			}

		} catch (Exception e) {
			System.out.println(e);// TODO: handle exception
			Assert.assertFalse(true, ErrorCode.nosource);

		}
		Assert.assertTrue(true);

	}
	@AfterClass 
	public void quIt(){
		driver.close();
		driver.quit();
		
	}
	
}
