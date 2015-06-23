package AllPullMenu;

/**
 * 确认首页所有分支页面，tab页面，显示情况
 */
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pagesbuilt.InterFLoginTitle;
import waitsource.wait;
import dosource.NewDo;
import errormessage.ErrorCode;
//import pagesbuilt.InterFRegister;
//import waitsource.wait;
//import datasource.BrowsersSet;
//import datasource.BrowsersType;
//import dosource.NewDo;
//import errormessage.ErrorCode;
import asuites.agencyLogin;


public class PullTitle {

	private WebDriver driver;
	private NewDo du;
	private wait wat;

	@BeforeClass
	public static void init() {
		agencyLogin.inialize();

	}
	@Test
	public void chkMsgTitle() {
		try {

			Assert.assertEquals(du.what(InterFLoginTitle.Msg).isDisplayed(),
					true);
			Assert.assertTrue(du.what(InterFLoginTitle.Msg).isEnabled(),
					"上行页面消息按钮显示正常");
			wat.waitFor(1000);
		    for(int num=0;num<3;num++){
		    	du.what(InterFLoginTitle.Msg).click();	
		    }
		    Assert.assertTrue(du.what(InterFLoginTitle.MsgName).isEnabled(),
					"上行页面消息按钮点击切换显示正常");

		} catch (Exception e) {
			System.out.println(e + ErrorCode.nosource);
		}
	}
	@Test
	public void chkCartTitle() {
		try {

			Assert.assertEquals(du.what(InterFLoginTitle.Cart).isDisplayed(),
					true);
			Assert.assertTrue(du.what(InterFLoginTitle.Cart).isEnabled(),
					"上行页面购物车按钮显示正常");
			

		} catch (Exception e) {
			System.out.println(e + ErrorCode.nosource);
		}
	}
	@Test
	public void chkFavTitle() {
		try {

			Assert.assertEquals(du.what(InterFLoginTitle.Cart).isDisplayed(),
					true);
			Assert.assertTrue(du.what(InterFLoginTitle.Cart).isEnabled(),
					"上行页面购物车按钮显示正常");

		} catch (Exception e) {
			System.out.println(e + ErrorCode.nosource);
		}
	}
	@Test
	public void chkWorkTitle() {
		try {

			Assert.assertEquals(du.what(InterFLoginTitle.Cart).isDisplayed(),
					true);
			Assert.assertTrue(du.what(InterFLoginTitle.Cart).isEnabled(),
					"上行页面工作台按钮显示正常");

		} catch (Exception e) {
			System.out.println(e + ErrorCode.nosource);
		}
	}
	@Test
	public void chkHelpTitle() {
		try {

			Assert.assertEquals(du.what(InterFLoginTitle.Help).isDisplayed(),
					true);
			Assert.assertTrue(du.what(InterFLoginTitle.Help).isEnabled(),
					"上行页面帮助按钮显示正常");

		} catch (Exception e) {
			System.out.println(e + ErrorCode.nosource);
		}
	}
	@Test
	public void chkExitTitle() {
		try {

			Assert.assertEquals(du.what(InterFLoginTitle.Exit).isDisplayed(),
					true);
			Assert.assertTrue(du.what(InterFLoginTitle.Exit).isEnabled(),
					"上行页面退出按钮显示正常");

		} catch (Exception e) {
			System.out.println(e + ErrorCode.nosource);
		}
	}
	@AfterClass
	public void closeWinHandle(){
		driver.close();
		driver.quit();
		
	}
}