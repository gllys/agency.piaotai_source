package registsagency;


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
	private  wait wat;
	//private ParseProperties getflush;
	
	@BeforeClass
	public void inialize(){
		BrowsersSet browser = new BrowsersSet(BrowsersType.chrome);
		driver = browser.web_driver;
		du = new Do(driver);
		driver.manage().window().maximize();
	}
	
	@Test
	public void regAgency(){
		
		
		SimplyHomePage simplyhomepage = new SimplyHomePage(driver);
		SimplyRegisterOnAgency simplyregisteronagency = new SimplyRegisterOnAgency(driver);
		
	//初始化2个封装后便可以调用
		/**
		 * 
		 * Description :JS to specific window.
		 * @author ：Gllys
		 * @see : 
		 * @param :
		 * @return : void
		 * @create ：2015-04-20
		 * @exception :
		 * @version ：1.0
		 */

		try {
			simplyhomepage.geturl();
			simplyhomepage.register();
			String currentUrl = driver.getCurrentUrl();
			((JavascriptExecutor)driver).executeScript("document.getElementById(\"verifycode\").class ='form-control validate[required]';");
			wat.waitFor(1000);
			((JavascriptExecutor)driver).executeScript("document.getElementById(\"verifycode\").name ='RegisterForm[1]';");
			wat.waitFor(1000);
			((JavascriptExecutor)driver).executeScript("document.getElementById(\"code\").class ='form-control validate[required]';");
			wat.waitFor(1000);
			((JavascriptExecutor)driver).executeScript("document.getElementById(\"code\").name ='RegisterForm[1]';");
			
			simplyregisteronagency.setAccount(InterFRegister.useraccountnumber);
			simplyregisteronagency.setPassword(InterFRegister.userpasswordnumber);
			simplyregisteronagency.setmoblie(InterFRegister.mobilenumber);
			
			try {
				simplyregisteronagency.regsubmit();	
			} catch (Exception e) {
				System.out.println(e);
				// TODO: handle exception
			}
				
		} catch (Exception e) {
			System.out.println(e);// TODO: handle exception
			Assert.assertFalse(true, ErrorCode.nosource);
			
		}
		Assert.assertTrue(true);
		
	}
	

}
