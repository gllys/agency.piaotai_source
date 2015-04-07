package pagesbuilt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dosource.NewDo;
import pagesbuilt.InterFRegister;

public class SimplyRegisterOnAgency {

	private WebDriver driver;
	private NewDo du;

	public SimplyRegisterOnAgency(WebDriver driver) {
		this.driver = driver;
		du = new NewDo(driver);
	}

	public SimplyRegisterOnAgency setAccount(String accountvalue) {
		du.what(InterFRegister.useraccount).sendKeys(accountvalue);
		return this;
	}

	public SimplyRegisterOnAgency setPassword(String passwordvalue) {
		for (WebElement eachpassword:du.whats(InterFRegister.userpassword)) {

			eachpassword.sendKeys(passwordvalue);
		}

		return this;
	}
	/**
	 * @author Gllys
	 * @serialData 2015-04-07
	 */

	public void regsubmit() {
		du.what(InterFRegister.regsubmit).click();
	}

	public WebElement getWebElement(String wm) {
		return du.what(wm);
	}
	
	public WebElement getWebElement(String wm,String accountname){
		return du.what(String.format(wm, accountname));
	}
}
