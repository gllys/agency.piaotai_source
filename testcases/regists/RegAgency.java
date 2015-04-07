package regists;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pagesbuilt.HomePage;
import pagesbuilt.SimplyHomePage;
import pagesbuilt.SimplyRegisterOnAgency;
import readproperties.ParseProperties;
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
	public void regagency(){
		SimplyHomePage simplyhomepage = new SimplyHomePage(driver);
		SimplyRegisterOnAgency simplyregisteronagency = new SimplyRegisterOnAgency(driver);
		
	//��ʼ��2����װ�����Ե���
		
		simplyhomepage.geturl();
		simplyhomepage.register();
		
		simplyregisteronagency.setAccount("gllysleletian");
		simplyregisteronagency.setPassword("0823letian");
		simplyregisteronagency.regsubmit();
		
	}
}
