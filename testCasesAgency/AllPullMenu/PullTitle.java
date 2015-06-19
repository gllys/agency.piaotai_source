package AllPullMenu;

/**
 * ȷ����ҳ���з�֧ҳ�棬tabҳ�棬��ʾ���
 */
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pagesbuilt.InterFLoginTitle;
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
	public static void init() {
		agencyLogin.inialize();

	}
	@Test
	public void chkMsgTitle() {
		try {

			Assert.assertEquals(du.what(InterFLoginTitle.Msg).isDisplayed(),
					true);
			Assert.assertTrue(du.what(InterFLoginTitle.Msg).isEnabled(),
					"����ҳ����Ϣ��ť��ʾ����");
			wat.waitFor(1000);
		    for(int num=0;num<3;num++){
		    	du.what(InterFLoginTitle.Msg).click();	
		    }
		    Assert.assertTrue(du.what(InterFLoginTitle.MsgName).isEnabled(),
					"����ҳ����Ϣ��ť����л���ʾ����");

		} catch (Exception e) {
			System.out.println(e + ErrorCode.nosource);
		}
	}
	@Test
	public void chkCartTitle() {
		try {

			Assert.assertEquals(du.what(InterFLoginTitle.Cart).isDisplayed(),
					true);
			Assert.assertTrue(du.what(InterFLoginTitle.Cart).isEnabled(),
					"����ҳ�湺�ﳵ��ť��ʾ����");
			

		} catch (Exception e) {
			System.out.println(e + ErrorCode.nosource);
		}
	}
	@Test
	public void chkFavTitle() {
		try {

			Assert.assertEquals(du.what(InterFLoginTitle.Cart).isDisplayed(),
					true);
			Assert.assertTrue(du.what(InterFLoginTitle.Cart).isEnabled(),
					"����ҳ�湺�ﳵ��ť��ʾ����");

		} catch (Exception e) {
			System.out.println(e + ErrorCode.nosource);
		}
	}
	@Test
	public void chkWorkTitle() {
		try {

			Assert.assertEquals(du.what(InterFLoginTitle.Cart).isDisplayed(),
					true);
			Assert.assertTrue(du.what(InterFLoginTitle.Cart).isEnabled(),
					"����ҳ�湤��̨��ť��ʾ����");

		} catch (Exception e) {
			System.out.println(e + ErrorCode.nosource);
		}
	}
	@Test
	public void chkHelpTitle() {
		try {

			Assert.assertEquals(du.what(InterFLoginTitle.Help).isDisplayed(),
					true);
			Assert.assertTrue(du.what(InterFLoginTitle.Help).isEnabled(),
					"����ҳ�������ť��ʾ����");

		} catch (Exception e) {
			System.out.println(e + ErrorCode.nosource);
		}
	}
	@Test
	public void chkExitTitle() {
		try {

			Assert.assertEquals(du.what(InterFLoginTitle.Exit).isDisplayed(),
					true);
			Assert.assertTrue(du.what(InterFLoginTitle.Exit).isEnabled(),
					"����ҳ���˳���ť��ʾ����");

		} catch (Exception e) {
			System.out.println(e + ErrorCode.nosource);
		}
	}
}