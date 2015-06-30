package registsAgency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;







import net.sourceforge.htmlunit.corejs.javascript.ObjArray;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pagesbuilt.InterFRegister;
import waitsource.wait;
import datasource.BrowsersSet;
import datasource.BrowsersType;
import dosource.NewDo;

public class RegInfoAgency {

	private NewDo du;
	private WebDriver driver;
	private wait wat;
	
	@BeforeClass
	public void inialize() {
		BrowsersSet browser = new BrowsersSet(BrowsersType.chrome);
		driver = browser.web_driver;
		du = new NewDo(driver);
		wat = new wait(driver);
		driver.manage().window().maximize();
		driver.get(InterFRegister.local);
		wat.waitFor(5000);
		du.what(InterFRegister.useraccount).sendKeys(InterFRegister.useraccountnumber);
		du.what(InterFRegister.userpassword).sendKeys(InterFRegister.userpasswordnumber);
		du.what(InterFRegister.userloginbtn).click();
	}
	
	@Test
	public void chkFirstpage(){
		Assert.assertEquals(du.what(InterFRegister.dashfirstpage).getText(),"散客预定");	
	}
	@Test
	public void chkToptitle(){
		int n = 0;
		List<String> tmp = new ArrayList<String>();
		List<WebElement> alltoptitles = du.whats(InterFRegister.dashtoptitle);
		List<String> chklist = new ArrayList<String>();
//		 "消息","购物车","收藏","工作台","在线帮助","退出"
		chklist.add("消息");
		chklist.add("购物车");
		chklist.add("收藏");
		chklist.add("工作台");
		chklist.add("在线帮助");
		chklist.add("退出");
		String[] AAAA    = new String[80];
		for(WebElement eachtoptitles : alltoptitles){
			AAAA[n] = eachtoptitles.getText();
			for(String str:AAAA){  
	            if(str!=null && str.length()!=0){  
	                tmp.add(str);  
	            }  
	        }  

		++n;
		}
		for(int i = 0 ; i < tmp.size() - 1;i ++){ 
		    for(int j = tmp.size() - 1;j > i;j--){ 
		      if(tmp.get(j).equals(tmp.get(i))){ 
		    	  tmp.remove(j); }
		      } 
		    } 
		System.out.println(tmp);
		Assert.assertEquals(tmp.equals(chklist),true);
	}
	@AfterClass
	public void quIt()
	{
		driver.close();
		driver.quit();
	}
}

