package loginAgency;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pagesbuilt.InterFRegister;
import switchsource.Switch;
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

	@Test
	public void checkValue() {
		driver.get(InterFRegister.local);
		wat.waitForElementPresent(InterFRegister.dashpicture);
		int titlenum = 6;
		int realtitlenum = Integer.valueOf(du.whats(InterFRegister.dashtitle)
				.size());
		Assert.assertEquals(titlenum, realtitlenum);
	}

	@Test
	public void checkSix() {
		driver.get(InterFRegister.local);
		wat.waitForElementPresent(InterFRegister.dashpicture);
		List<WebElement> alltitles = du.whats(InterFRegister.dashtitle);
		String[] titlelist = { "首页", "票台介绍", "如何入驻", "配套设备", "合作资质", "联系我们" };
		int num = 0;
		for (WebElement eachtitle : alltitles) {
			Assert.assertEquals(eachtitle.getText(), titlelist[num]);
			++num;
		}
	}

	@Test
	public void checkBtn() {
		// Actions dargger = new Actions(driver);
		driver.get(InterFRegister.local);
		du.what(InterFRegister.shouye).click();
		Assert.assertEquals(du.what(InterFRegister.piaotaijieshao)
				.isDisplayed(), true);

		Assert.assertEquals(du.what(InterFRegister.ruheruzhu).isDisplayed(),
				true);
		Assert.assertEquals(du.what(InterFRegister.peitaoshebei).isDisplayed(),
				true);
		Assert.assertEquals(du.what(InterFRegister.hezuozizhi).isDisplayed(),
				true);
		Assert.assertEquals(du.what(InterFRegister.lianxiwomen).isDisplayed(),
				true);
		Assert.assertEquals(
				du.what(InterFRegister.shouye).getLocation().getY(),
				du.what(InterFRegister.piaotaijieshao).getLocation().getY());

	}

	@Test
	public void checkOutBtn() {
		driver.get(InterFRegister.local);
		du.what(InterFRegister.weibo).click();
		
		Switch switchWin = new Switch(driver);
		Set<String> ahandles = driver.getWindowHandles();
		String titlename = null;
		for (String handle : ahandles) {
			titlename = driver.switchTo().window(handle).getTitle();
		}
		wat.waitFor(5000);
		if(titlename.contains("微博")){
			Assert.assertTrue(true);	
		}
		switchWin.toSpecificWindow(InterFRegister.agencywindowsname);
	}
	
	@Test
	public void checkWeiXinBtn(){
		//Actions dargger = new Actions(driver);
		driver.get(InterFRegister.local);
		wat.waitFor(7000);
		driver.findElement(By.xpath(InterFRegister.weixin)).click();
		wat.waitFor(3000);
		Assert.assertEquals(driver.findElement(By.xpath(InterFRegister.weixinerweima)).isDisplayed(), true);

		
	
	}
	
	@AfterClass
	public void closeWinHandle(){
		driver.close();
		driver.quit();
		
	}
	
}
