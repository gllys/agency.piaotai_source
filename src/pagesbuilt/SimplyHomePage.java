package pagesbuilt;

import org.openqa.selenium.WebDriver;

import dosource.Do;

public class SimplyHomePage {

	private WebDriver driver;
	private Do du;
	
	public SimplyHomePage(WebDriver driver){
		this.driver = driver;
		du = new Do(driver);
	}
	public SimplyHomePage geturl(){
		driver.get(InterFRegister.local);
		return this;
	}
	
	public void register(){
		du.what(InterFRegister.getinreg).click();
		
	}
}

