package AllPullMenu;
/**
 * 登录页面左侧Pull菜单显示以及按钮功能chk
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import com.thoughtworks.selenium.Selenium;



import asuites.agencyLogin;
import pagesbuilt.InterFLogin;
import pagesbuilt.InterFRegister;
import waitsource.wait;
import datasource.BrowsersSet;
import datasource.BrowsersType;
import dosource.NewDo;
import errormessage.ErrorCode;

public class Pulltive {
	//private Actions action;

	 private WebDriver driver;
	 private NewDo du;
	 private wait wat;
	@BeforeClass
	public void init()
	{
	agencyLogin.inialize();
	
	}
		
	@Test
	public void chkTicketBash()
	{
	    Assert.assertEquals(du.what(InterFLogin.ticket).isEnabled(),true);
//	    du.what(InterFLogin.ticket).click();
//	    du.waitFor(2000);
	    du.waitFor(2000);
	   try{ 
		System.out.println(du.what(InterFLogin.sale+"/a").getText());
	    Assert.assertEquals(du.what(InterFLogin.sale).isDisplayed(),true);
	    System.out.println(du.what(InterFLogin.group+"/a").getText());
	    Assert.assertEquals(du.what(InterFLogin.group).isDisplayed(),true);
	    System.out.println(du.what(InterFLogin.cart+"/a").getText());
	    Assert.assertEquals(du.what(InterFLogin.cart).isDisplayed(),true);
	    System.out.println(du.what(InterFLogin.favourite+"/a").getText());
	    Assert.assertEquals(du.what(InterFLogin.favourite).isDisplayed(),true);
	   }
	catch(Exception e)
	   {
		System.out.println(e);
	   }
	}
	
	@Test
	public void chkTicketSale()//门票&&门票下的子页按钮&&文字确认
	{
				try{	
				du.what(InterFLogin.sale).click();
				wat.waitFor(2000);
				System.out.println(du.what(InterFLogin.saleName).getText());
				Assert.assertEquals(du.what(InterFLogin.saleName).getText(),"散客结算价");
				
				}
				catch(Exception e)
				{System.out.println(e+ErrorCode.nosource);}	
	}
	@Test
	public void chkTicketGroup()
	{
				try{	
				du.what(InterFLogin.group).click();
				wat.waitFor(2000);
				System.out.println(du.what(InterFLogin.groupName).getText());
				Assert.assertEquals(du.what(InterFLogin.groupName).getText(),"团队结算价");
				
				}
				catch(Exception e)
				{System.out.println(e+ErrorCode.nosource);}	
	}
	@Test
	public void chkTicketCart()
	{
				try{	
				du.what(InterFLogin.cart).click();
				wat.waitFor(2000);
				System.out.println(du.what(InterFLogin.cartName).getText());
				Assert.assertEquals(du.what(InterFLogin.cartName).getText(),"我的购物车");
				
				}
				catch(Exception e)
				{System.out.println(e+ErrorCode.nosource);}	
	}
	@Test
	public void chkTicketFavourite()
	{
				try{	
				du.what(InterFLogin.favourite).click();
				wat.waitFor(2000);
				System.out.println(du.what(InterFLogin.favouriteName).getText());
				Assert.assertEquals(du.what(InterFLogin.favouriteName).getText(),"我的收藏");
				
				}
				catch(Exception e)
				{System.out.println(e+ErrorCode.nosource);}	
	}
	@Test
	public void chkOrderBash()//订单&&下级子页&&文字确认
	{
		try {
			for(int sum = 0;sum<3;sum++){
			du.what(InterFLogin.order).click();
			wat.waitFor(2000);}
			Assert.assertEquals(du.what(InterFLogin.ordermanage).isDisplayed(), true);
			Assert.assertEquals(du.what(InterFLogin.refundorder).isDisplayed(), true);
			Assert.assertEquals(du.what(InterFLogin.applycheck).isDisplayed(), true);
		} catch (Exception e) {
			System.out.println(e+ErrorCode.nosource);// TODO: handle exception
		}
	}
	@Test
	public void chkOrderTicket()
	{
		try {
			if(!du.what(InterFLogin.ordermanage).isEnabled())
			{
				System.out.println("订单管理按钮失效");
				Assert.fail();
				}
			du.what(InterFLogin.ordermanage).click();
			Assert.assertEquals(du.what(InterFLogin.ordermanage + "/@class"),"class=active");
		} catch (Exception e) {
			System.out.println(e+ErrorCode.nosource);// TODO: handle exception
		}
	}
	@Test
	public void chkOrderRefund()
	{
		try {
			Assert.assertEquals(du.what(InterFLogin.refundorder).isEnabled(),true);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@AfterClass
	public void closeWinHandle(){
		driver.close();
		driver.quit();
		
	}
}


