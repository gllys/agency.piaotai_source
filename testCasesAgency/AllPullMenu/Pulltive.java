package AllPullMenu;

/**
 * 登录页面左侧Pull菜单显示以及按钮功能chk
 * 
 */
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.interactions.Action;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pagesbuilt.InterFLogin;
import pagesbuilt.InterFRegister;
import waitsource.wait;
import datasource.BrowsersSet;
import datasource.BrowsersType;
import dosource.NewDo;
import errormessage.ErrorCode;

public class Pulltive {
	// private Actions action;

	private WebDriver driver;
	private NewDo du;
	private wait wat;

	@BeforeClass
	public void init() {
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

	@Test(priority = 1)
	public void chkTicketBash() {// 门票
		Assert.assertEquals(du.what(InterFLogin.ticket).isDisplayed(), true);
		// du.what(InterFLogin.ticket).click();
		// du.waitFor(2000);
		du.waitFor(2000);
		try {
			System.out.println(du.what(InterFLogin.sale).getText());
			Assert.assertEquals(du.what(InterFLogin.sale).isDisplayed(), true);
			System.out.println(du.what(InterFLogin.group + "/a").getText());
			Assert.assertEquals(du.what(InterFLogin.group).isDisplayed(), true);
			System.out.println(du.what(InterFLogin.cart + "/a").getText());
			Assert.assertEquals(du.what(InterFLogin.cart).isDisplayed(), true);
			System.out.println(du.what(InterFLogin.favourite + "/a").getText());
			Assert.assertEquals(du.what(InterFLogin.favourite).isDisplayed(),
					true);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test(priority = 2)
	public void chkTicketSale()// 门票&&门票下的子页按钮&&文字确认
	{
		try {
			du.what(InterFLogin.sale).click();
			wat.waitFor(2000);
			System.out.println(du.what(InterFLogin.saleName).getText());
			Assert.assertEquals(du.what(InterFLogin.saleName).getText(),
					"散客结算价");

		} catch (Exception e) {
			System.out.println(e + ErrorCode.nosource);
		}
	}

	@Test(priority = 3)
	public void chkTicketGroup() {
		try {
			du.what(InterFLogin.group).click();
			wat.waitFor(2000);
			System.out.println(du.what(InterFLogin.groupName).getText());
			Assert.assertEquals(du.what(InterFLogin.groupName).getText(),
					"团队结算价");

		} catch (Exception e) {
			System.out.println(e + ErrorCode.nosource);
		}
	}

	@Test(priority = 4)
	public void chkTicketCart() {
		try {
			du.what(InterFLogin.cart).click();
			wat.waitFor(2000);
			System.out.println(du.what(InterFLogin.cartName).getText());
			Assert.assertEquals(du.what(InterFLogin.cartName).getText(),
					"我的购物车");

		} catch (Exception e) {
			System.out.println(e + ErrorCode.nosource);
		}
	}

	@Test(priority = 5)
	public void chkTicketFavourite() {
		try {
			du.what(InterFLogin.favourite).click();
			wat.waitFor(2000);
			System.out.println(du.what(InterFLogin.favouriteName).getText());
			Assert.assertEquals(du.what(InterFLogin.favouriteName).getText(),
					"我的收藏");

		} catch (Exception e) {
			System.out.println(e + ErrorCode.nosource);
		}
	}

	@Test(priority = 6)
	public void chkOrderBash()// 订单&&下级子页&&文字确认
	{
		try {
			Assert.assertEquals(du.what(InterFLogin.order).isEnabled(), true);
			du.waitFor(2000);
			try {
				System.out.println(du.what(InterFLogin.ordermanage + "/a")
						.getText());
				Assert.assertEquals(du.what(InterFLogin.ordermanageName)
						.isDisplayed(), true);
				System.out.println(du.what(InterFLogin.refundorder + "/a")
						.getText());
				Assert.assertEquals(du.what(InterFLogin.refundorderName)
						.isDisplayed(), true);
				System.out.println(du.what(InterFLogin.applycheck + "/a")
						.getText());
				Assert.assertEquals(du.what(InterFLogin.applycheckName)
						.isDisplayed(), true);

			} catch (Exception e) {
				System.out.println(e);
			}
			for (int sum = 0; sum < 3; sum++) {
				du.what(InterFLogin.order).click();
				wat.waitFor(2000);
			}
			Assert.assertEquals(du.what(InterFLogin.ordermanage).isDisplayed(),
					true);
			Assert.assertEquals(du.what(InterFLogin.refundorder).isDisplayed(),
					true);
			Assert.assertEquals(du.what(InterFLogin.applycheck).isDisplayed(),
					true);
		} catch (Exception e) {
			System.out.println(e + ErrorCode.nosource);// TODO: handle exception
		}
	}

	@Test(priority = 7)
	public void chkOrderTicket() {
		try {
			if (!du.what(InterFLogin.ordermanage).isEnabled()) {
				System.out.println("订单管理按钮失效");
				Assert.fail();
			}
			for (int sum = 0; sum < 3; sum++) {
				du.what(InterFLogin.ordermanage).click();

			}
			Assert.assertEquals(du.what(InterFLogin.ordermanage).isDisplayed(),
					true);
			
		} catch (Exception e) {
			System.out.println(e + ErrorCode.nosource);// TODO: handle exception
		}
	}

	@Test(priority = 8)
	public void chkOrderRefund() {
		try {
			Assert.assertEquals(du.what(InterFLogin.refundorder).isDisplayed(),
					true);
			for (int sum = 0; sum < 3; sum++) {
				du.what(InterFLogin.refundorder).click();

			}
			Assert.assertEquals(du.what(InterFLogin.refundorderName)
					.isEnabled(), true);
		} catch (Exception e) {
			System.out.println(e + ErrorCode.nosource);// TODO: handle exception
		}
	}

	@Test(priority = 9)
	public void chkOrderApplyCheck() {
		try {
			Assert.assertEquals(du.what(InterFLogin.applycheck).isDisplayed(),
					true);
			for (int sum = 0; sum < 3; sum++) {
				du.what(InterFLogin.applycheck).click();
			}
			Assert.assertEquals(
					du.what(InterFLogin.applycheckName).isEnabled(), true);
		} catch (Exception e) {
			System.out.println(e + ErrorCode.nosource);// TODO: handle exception
		}
	}

	@Test(priority = 10)
	public void chkAddUp() {// 统计页面
		try {
			try {
				System.out.println(du.what(InterFLogin.addup + "/a").getText());
				Assert.assertEquals(du.what(InterFLogin.addupbuyName).isDisplayed(), true);

			} catch (Exception e) {
				System.out.println(e);
			}
			Assert.assertEquals(du.what(InterFLogin.addup).isDisplayed(), true);
			for (int sum = 0; sum < 3; sum++) {
				du.what(InterFLogin.addup).click();
			}
			Assert.assertEquals(du.what(InterFLogin.addupbuyName).isEnabled(),
					true);
		} catch (Exception e) {
			System.out.println(e + ErrorCode.nosource);// TODO: handle exception
		}
	}

	@Test(priority = 11)
	public void chkBalance() {// 结算
		try {
			try {
				System.out.println(du.what(InterFLogin.shouldpayment + "/a")
						.getText());
				Assert.assertEquals(du.what(InterFLogin.shouldpaymentName)
						.isDisplayed(), true);
				System.out.println(du.what(InterFLogin.platform + "/a")
						.getText());
				Assert.assertEquals(du.what(InterFLogin.platformName)
						.isDisplayed(), true);
				System.out.println(du.what(InterFLogin.property + "/a")
						.getText());
				Assert.assertEquals(du.what(InterFLogin.propertyName)
						.isDisplayed(), true);
				System.out.println(du.what(InterFLogin.blotter + "/a")
						.getText());
				Assert.assertEquals(du.what(InterFLogin.blotterName)
						.isDisplayed(), true);
				System.out.println(du.what(InterFLogin.bankcard + "/a")
						.getText());
				Assert.assertEquals(du.what(InterFLogin.bankcardName)
						.isDisplayed(), true);

			} catch (Exception e) {
				System.out.println(e);
			}
			Assert.assertEquals(du.what(InterFLogin.balance).isDisplayed(),
					true);
			for (int sum = 0; sum < 3; sum++) {
				du.what(InterFLogin.balance).click();
			}
			Assert.assertEquals(du.what(InterFLogin.shouldpayment).isEnabled(),
					true);
		} catch (Exception e) {
			System.out.println(e + ErrorCode.nosource);// TODO: handle exception
		}
	}

	@AfterClass
	public void closeWinHandle() {
		driver.close();
		driver.quit();

	}
}
