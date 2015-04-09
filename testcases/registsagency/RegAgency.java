package registsagency;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import pagesbuilt.InterFRegister;
import pagesbuilt.SimplyHomePage;
import pagesbuilt.SimplyRegisterOnAgency;

import datasource.BrowsersSet;
import datasource.BrowsersType;
import dosource.Do;

public class RegAgency {

	
	
	private WebDriver driver;
	private Do du;
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
		
		simplyhomepage.geturl();
		simplyhomepage.register();
		
		simplyregisteronagency.setAccount(InterFRegister.useraccountnumber);
		simplyregisteronagency.setPassword(InterFRegister.userpasswordnumber);
		simplyregisteronagency.setmoblie(InterFRegister.mobilenumber);
		
		simplyregisteronagency.regsubmit();
		
	}
	

}
