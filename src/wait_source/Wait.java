package wait_source;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public class Wait {
	private WebDriver driver;//定义driver
    private int timeout =30; //定义超时时间为10S
	
	public Wait(WebDriver driver){
		this.driver = driver;//必须要使用This,this是指向后跟的driver为前定义的webdriver而不是后赋予的driver
        //PageFactory .initElements(driver, this);	-----> 解决页面元素过期的问题	
	}
	
	public void waitForElementPresent(String locator){
		try{
			(new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		}catch(Exception e){
			
		}
		
	}

	
	public void waitForElementIsEnable(String locator){
		(new WebDriverWait(driver, timeout)).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}
	
	public void waitFor(long timeout){
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
