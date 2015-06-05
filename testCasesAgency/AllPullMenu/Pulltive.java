package AllPullMenu;
/**
 * 登录页面左侧Pull菜单显示以及按钮功能chk
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
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
	public void chkTicketSale()
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
	public void chkOrderBash()
	{
		
	}
}


