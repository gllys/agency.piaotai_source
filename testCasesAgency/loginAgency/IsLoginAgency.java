package loginAgency;
//alwaysRun 				If set to true, this test method will always be run even if it depends on a method that failed.
//dataProvider 				The name of the data provider for this test method.
//dataProviderClass 		The class where to look for the data provider. If not specified, the data provider will be looked on the class of the current test method or one of its base classes. If this attribute is specified, the data provider method needs to be static on the specified class.
//dependsOnGroups 			The list of groups this method depends on.
//dependsOnMethods 			The list of methods this method depends on.
//description 				The description for this method.
//enabled 					Whether methods on this class/method are enabled.
//expectedExceptions 		The list of exceptions that a test method is expected to throw. If no exception or a different than one on this list is thrown, this test will be marked a failure.
//groups 					The list of groups this class/method belongs to.
//invocationCount 			The number of times this method should be invoked.
//invocationTimeOut 		The maximum number of milliseconds this test should take for the cumulated time of all the invocationcounts. This attribute will be ignored if invocationCount is not specified.
//priority 					The priority for this test method. Lower priorities will be scheduled first.
//successPercentage 		The percentage of success expected from this method
//singleThreaded 			If set to true, all the methods on this test class are guaranteed to run in the same thread, even if the tests are currently being run with parallel="methods". This attribute can only be used at the class level and it will be ignored if used at the method level. Note: this attribute used to be called sequential (now deprecated).
//timeOut 					The maximum number of milliseconds this test should take.
//threadPoolSize 			The size of the thread pool for this method. The method will be invoked from multiple threads as specified by invocationCount.
//Note: 					this attribute is ignored if invocationCount is not specified 



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pagesbuilt.InterFRegister;
import datasource.BrowsersSet;
import datasource.BrowsersType;
import dosource.NewDo;
import waitsource.wait;
public class IsLoginAgency {

	private WebDriver driver;
	private NewDo du;
	private wait wat;
	@BeforeClass
	public void inialize(){
		BrowsersSet browser = new BrowsersSet(BrowsersType.chrome);
		driver = browser.web_driver;
		du = new NewDo(driver);
		wat = new wait(driver);
		driver.manage().window().maximize();
		driver.get(InterFRegister.local);
	}
	
	@Test(priority = 1)
	public void chkDivError(){
		wat.waitForElementPresent(InterFRegister.dashpicture);
		du.what(InterFRegister.useraccount).click();
		wat.waitFor(3000);
		du.what(InterFRegister.userpassword).click();
		try {
			WebElement useraccountNUllchk = du.what(InterFRegister.regformError);
			System.out.println(useraccountNUllchk.getText());
			Assert.assertEquals(useraccountNUllchk.getText(), "* 此处不可空白");
		} catch (Exception e) {
		System.out.println(e);	// TODO: handle exception
		}
		wat.waitFor(3000);
		du.what(InterFRegister.useraccount).click();
		try {
			WebElement userpasswordNUllchk = du.what(InterFRegister.regformError);
			System.out.println(userpasswordNUllchk.getText());
			Assert.assertEquals(userpasswordNUllchk.getText(), "* 此处不可空白");
		} catch (Exception e) {
		System.out.println(e);	// TODO: handle exception
		}
	}
	@Test(priority = 2)
	public void chkResetPwd(){
		du.what(InterFRegister.resetpwd).click();
		du.what(InterFRegister.reuseraccount).sendKeys("!@#$%^&*(");
		wat.waitFor(3000);
		du.what(InterFRegister.regetcodebtn).click();
		try {
			WebElement reuseraccounterrorstring = du.what(InterFRegister.reaccountformError);
			System.out.println(reuseraccounterrorstring.getText());
			Assert.assertEquals(reuseraccounterrorstring.getText(),"用户名不存在！");
		} catch (Exception e) {
			Assert.assertFalse(false);// TODO: handle exception
		}
		du.what(InterFRegister.reuserpwd).sendKeys("12345");
		du.what(InterFRegister.reuserchkpwd).sendKeys("12345");
		du.what(InterFRegister.resubmitbtn).click();
		try {
			WebElement reuserpwderrorstring = du.what(InterFRegister.repwdformError);
			System.out.println(reuserpwderrorstring.getText());
			Assert.assertEquals(reuserpwderrorstring.getText(),"密码必须为6位");
		} catch (Exception e) {
			Assert.assertFalse(false);// TODO: handle exception
		}
		du.what(InterFRegister.reuserpwd).clear();
		du.what(InterFRegister.reuserchkpwd).clear();
		du.what(InterFRegister.reuserpwd).sendKeys("123456");
		du.what(InterFRegister.reuserchkpwd).sendKeys("123457");
		du.what(InterFRegister.resubmitbtn).click();
		try {
			WebElement reuserMSGerrorstring = du.what(InterFRegister.remessageformError);
			System.out.println(reuserMSGerrorstring.getText());
			Assert.assertEquals(reuserMSGerrorstring.getText(),"两次密码输入不一致");
		} catch (Exception e) {
			Assert.assertFalse(false);// TODO: handle exception
		}
		
	}
	@Test(priority = 3)
	public void chkbtn(){
		
		Assert.assertEquals(du.what(InterFRegister.resubmitbtn).isEnabled(), true);
		Assert.assertEquals(du.what(InterFRegister.returnbackbtn).isEnabled(), true);
		Assert.assertEquals(du.what(InterFRegister.regetcodebtn).isEnabled(), true);
		wat.waitFor(3000);
		du.what(InterFRegister.returnbackbtn).click();
		wat.waitForElementPresent(InterFRegister.agencywindowsname);
		Assert.assertEquals(du.what(InterFRegister.dashtitle).isDisplayed(),true);
	}
	@Test(priority = 4)
	public void chkInlogin(){
		du.what(InterFRegister.useraccount).sendKeys(InterFRegister.useraccountnumber);
		du.what(InterFRegister.userpassword).sendKeys(InterFRegister.userpasswordnumber);
		du.what(InterFRegister.userloginbtn).click();
		wat.waitForElementIsEnable(InterFRegister.dashlogout);
		Assert.assertEquals(du.what(InterFRegister.dashleftlogo).isDisplayed(), true);
	}
}
