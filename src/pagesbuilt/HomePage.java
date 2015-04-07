package pagesbuilt;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;

	@FindBy(xpath = "")
	private WebElement reg;

	@FindBys(@FindBy(xpath = "|"))
	private List<WebElement> pas;

	@FindBy(xpath = "")
	private WebElement regBtn;

	public HomePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	/**
	 * @author Gllys
	 * @param regs
	 * @date 2015-04-07
	 */

	public void setUserId(String regs) {

		reg.sendKeys(regs);

	}

	public void setPassWord(String password) {
		for (WebElement eachpassword : pas)
			eachpassword.sendKeys(password);
	}

	public void clickBtn(String Btn) {

		regBtn.submit();
	}

}
