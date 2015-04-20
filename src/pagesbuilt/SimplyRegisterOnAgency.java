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
		du.what(InterFRegister.reguseraccount).sendKeys(accountvalue);
		return this;
	}

	public SimplyRegisterOnAgency setPassword(String passwordvalue) {
		for (WebElement eachpassword:du.whats(InterFRegister.reguserpassword)) {

			eachpassword.sendKeys(passwordvalue);
		}

		return this;
	}
	/**
	 * @author Gllys
	 * @serialData 2015-04-07
	 */

	public SimplyRegisterOnAgency setMoblie(String mobilenumber){
		du.what(InterFRegister.regmobile).sendKeys(mobilenumber);
		return this;
	}
	
	public SimplyRegisterOnAgency setVerify(String vertify){
		du.what(InterFRegister.regverifycode).sendKeys(vertify);
		return this;
	}
	
	public SimplyRegisterOnAgency setMobileVerify(String mobilevertify){
		du.what(InterFRegister.mobilecode).sendKeys(mobilevertify);
		return this;
	}
	
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
