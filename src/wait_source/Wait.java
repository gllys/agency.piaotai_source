package wait_source;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public class Wait {
	private WebDriver driver;//����driver
    private int timeout =30; //���峬ʱʱ��Ϊ10S
	
	public Wait(WebDriver driver){
		this.driver = driver;//����Ҫʹ��This,this��ָ������driverΪǰ�����webdriver�����Ǻ����driver
        //PageFactory .initElements(driver, this);	-----> ���ҳ��Ԫ�ع��ڵ�����	
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
