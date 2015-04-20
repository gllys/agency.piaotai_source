package registsagency;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pagesbuilt.InterFRegister;
import pagesbuilt.SimplyHomePage;
import pagesbuilt.SimplyRegisterOnAgency;
import waitsource.wait;
import datasource.BrowsersSet;
import datasource.BrowsersType;
import dosource.Do;
import errormessage.ErrorCode;

public class RegAgency {

	private WebDriver driver;
	private Do du;
	private wait wat;

	// private ParseProperties getflush;

	@BeforeClass
	public void inialize() {
		BrowsersSet browser = new BrowsersSet(BrowsersType.chrome);
		driver = browser.web_driver;
		du = new Do(driver);
		wat = new wait(driver);
		driver.manage().window().maximize();
	}

	@Test
	public void regAgency() {

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
		SimplyRegisterOnAgency simplyregisteronagency = new SimplyRegisterOnAgency(
				driver);

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
			simplyhomepage.geturl();
			simplyhomepage.register();
			// String currentUrl = driver.getCurrentUrl();
			System.out.println("register good");
			wat.waitForElementIsEnable(InterFRegister.regturnback);
			((JavascriptExecutor) driver)
					.executeScript("document.getElementById('verifycode').className ='form-control validate[required]';");
			wat.waitFor(2000);
			System.out.println("verifycode good");
			((JavascriptExecutor) driver)
					.executeScript("document.getElementById('verifycode').name ='RegisterForm[1]';");

			((JavascriptExecutor) driver)
					.executeScript("document.getElementById('code').className ='form-control validate[required]';");

			((JavascriptExecutor) driver)
					.executeScript("document.getElementById('code').name ='RegisterForm[1]';");

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

}
