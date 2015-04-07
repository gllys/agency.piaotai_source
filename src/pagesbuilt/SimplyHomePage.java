package pagesbuilt;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;

import dosource.NewDo;

public class SimplyHomePage {

	private WebDriver driver;
	private NewDo du;
	
	public SimplyHomePage(WebDriver driver){
		this.driver = driver;
		du = new NewDo(driver);
	}
	public SimplyHomePage geturl(){
		driver.get(InterFRegister.local);
		return this;
	}
	
	public void register(){
		driver.findElement(By.xpath(InterFRegister.getinreg)).click();
		
	}
}

