package AllPullMenu;
/**
 * ȷ����ҳ���з�֧ҳ�棬tabҳ�棬��ʾ���
 */
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




import waitsource.wait;
import dosource.NewDo;
import errormessage.ErrorCode;
//import pagesbuilt.InterFRegister;
//import waitsource.wait;
//import datasource.BrowsersSet;
//import datasource.BrowsersType;
//import dosource.NewDo;
//import errormessage.ErrorCode;
import asuites.agencyLogin;

public class PullTitle {

	 private WebDriver driver;
	 private NewDo du;
	 private wait wat;
	@BeforeClass
	public static void init(){
		agencyLogin.inialize();
			
}
	@Test
	public void Title(){
		try {
			Assert.assertEquals(du.what("").isDisplayed(),true);
			
			
		} catch (Exception e) {
			System.out.println(e+ErrorCode.nosource);
		}

		
		
	}
}
