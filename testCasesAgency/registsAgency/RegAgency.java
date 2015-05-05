package registsAgency;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pagesbuilt.InterFRegister;
import pagesbuilt.SimplyHomePage;
import pagesbuilt.SimplyRegisterOnAgency;
import waitsource.wait;
import datasource.BrowsersSet;
import datasource.BrowsersType;
import dosource.NewDo;
import errormessage.ErrorCode;

public class RegAgency {

	private WebDriver driver;
	private NewDo du;
	private wait wat;

	// private ParseProperties getflush;

	@BeforeClass
	public void inialize() {
		BrowsersSet browser = new BrowsersSet(BrowsersType.chrome);
		driver = browser.web_driver;
		du = new NewDo(driver);
		wat = new wait(driver);
		driver.manage().window().maximize();
		driver.get(InterFRegister.local);
	}
	
    @Test(priority = 1)
    public void chkRegTile(){
    	du.what(InterFRegister.getinreg).click();
    	String titlename = du.what(InterFRegister.regtitle).getText();
    	System.out.println(titlename);
    	Assert.assertEquals(titlename.trim(), "�����������˺�");
    	
    	
    }
	

	@Test(priority = 2)
	public void chkRegUserName() {

		//du.what(InterFRegister.getinreg).click();
		wat.waitFor(3000);
		du.what(InterFRegister.regsubmit).click();
		try {
			WebElement useraccountNULLerrorstring = du.what(InterFRegister.regformError);

			System.out.println(useraccountNULLerrorstring.getText());
			Assert.assertEquals(useraccountNULLerrorstring.getText(),
					"* �������û���");
		} catch (Exception e) {
			System.out.println("û�����ɿ��û����µ���ʾ " + ErrorCode.nosource);// TODO:
																		// handle
																		// exception
		}
		// ��֤Ĭ��״̬�µ�submit��ʾ����
		du.what(InterFRegister.reguseraccount).clear();
		du.what(InterFRegister.reguseraccount).sendKeys("12345");
		wat.waitFor(3000);
		du.what(InterFRegister.regtitle).click();
		try {
			WebElement useraccountNUMerrorstring = du.what(InterFRegister.regformError);
			System.out.println(useraccountNUMerrorstring.getText());
			Assert.assertEquals(useraccountNUMerrorstring.getText(),
					"* ��������Ч���û���,����6 ���ַ�");

		} catch (Exception e) {
			System.out.println("û�����ɴ����û�������(����6λ)�µ���ʾ " + ErrorCode.nosource);// TODO:
																				// handle
																				// exception
		}
		// ��֤��������6΢���ַ�submit
		du.what(InterFRegister.reguseraccount).clear();
		du.what(InterFRegister.reguseraccount).sendKeys("!@#$%^^&&*()");
		wat.waitFor(3000);
		du.what(InterFRegister.regtitle).click();
		try {
			WebElement useraccountFORMerrorstring = du.what(InterFRegister.regformError);
			System.out.println(useraccountFORMerrorstring.getText());
			Assert.assertEquals(useraccountFORMerrorstring.getText(),
					"* ��������Ч���û�����ֻ�ܰ������ĺ��֡�Ӣ����ĸ������");

		} catch (Exception e) {
			System.out.println("û�����ɴ����û��������µ���ʾ " + ErrorCode.nosource);// TODO:
																		// handle
																		// exception
		}
		// ����ķ���״̬
		du.what(InterFRegister.reguseraccount).clear();
		du.what(InterFRegister.reguseraccount).sendKeys("gllysleletian");
		wat.waitFor(3000);
		du.what(InterFRegister.regsubmit).click();
		try {
			WebElement useraccountEXTerrorstring = du.what(InterFRegister.regformError);
			System.out.println(useraccountEXTerrorstring.getText());
			Assert.assertEquals(useraccountEXTerrorstring.getText(), "�û����Ѵ���");

		} catch (Exception e) {
			System.out.println("û�������û��������µ���ʾ " + ErrorCode.nosource);// TODO:
																		// handle
																		// exception
		}
		// ��֤����
	}

	@Test(priority = 3)
	public void chkRegMobile() {
		du.what(InterFRegister.reguseraccount).clear();
		// ֻ��2�����Բ�������
		int lengthnum = 10;
		Random random = new Random();
		String base = "0123456789";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < lengthnum; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		String randomaccountNUM = sb.toString();
		int length = 6;
		String bases = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random2 = new Random();
		StringBuffer SBS = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random2.nextInt(bases.length());
			SBS.append(bases.charAt(number));
		}
		String randomaccount = SBS.toString();
		//du.what(InterFRegister.getinreg).click();
		du.what(InterFRegister.reguseraccount).sendKeys(randomaccount);
		wat.waitFor(3000);
		du.what(InterFRegister.regmobile).click();
		wat.waitFor(3000);
		du.what(InterFRegister.regtitle).click();
		try {
			WebElement usermobileNULLerrorstring = du.what(InterFRegister.regformError);
			System.out.println(usermobileNULLerrorstring.getText());
			Assert.assertEquals(usermobileNULLerrorstring.getText(), "* �������ֻ���");
		} catch (Exception e) {
			System.out.println(e + "��ֵ�µ��ֻ��Ŵ�����ʾû������");// TODO: handle exception
		}
        du.what(InterFRegister.regmobile).clear();
        du.what(InterFRegister.regmobile).sendKeys(randomaccountNUM);
        wat.waitFor(3000);
        du.what(InterFRegister.regtitle).click();
        try {
        	WebElement usermobileTENNUMerrorstring = du.what(InterFRegister.regformError);
			System.out.println(usermobileTENNUMerrorstring.getText());
			Assert.assertEquals(usermobileTENNUMerrorstring.getText(), "* ��������Ч���ֻ�����");
		} catch (Exception e) {
		System.out.println(e +" ����10λ�Ĵ����ֻ���û����ʾ");	// TODO: handle exception
		}
        du.what(InterFRegister.regmobile).clear();
        du.what(InterFRegister.regmobile).sendKeys(randomaccount);
        wat.waitFor(3000);
        du.what(InterFRegister.regtitle).click();
        try {
        	WebElement usermobileSTRerrorstring = du.what(InterFRegister.regformError);
			System.out.println(usermobileSTRerrorstring.getText());
			Assert.assertEquals(usermobileSTRerrorstring.getText(), "* ��������Ч���ֻ�����");
		} catch (Exception e) {
		System.out.println(e +" �ַ���");	// TODO: handle exception
		}
	}
	
	@Test(priority = 4)
	public void chkRegpwd(){
		//du.what(InterFRegister.getinreg).click();
		int length = 6;
		String bases = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random2 = new Random();
		StringBuffer SBS = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random2.nextInt(bases.length());
			SBS.append(bases.charAt(number));
		}
		String randomaccount = SBS.toString();
		du.what(InterFRegister.regmobile).clear();
		du.what(InterFRegister.reguseraccount).sendKeys(randomaccount);
		wat.waitFor(3000);
		du.what(InterFRegister.regmobile).sendKeys(InterFRegister.mobilenumber);
		du.what("//input [@id='password']").click();
		wat.waitFor(3000);
		du.what(InterFRegister.regtitle).click();
		try {
			WebElement userpasswordNULLerrorstring = du.what(InterFRegister.regformError);
			System.out.println(userpasswordNULLerrorstring.getText());
			Assert.assertEquals(userpasswordNULLerrorstring.getText(), "* ����������");
		} catch (Exception e) {
			System.out.println(e +" ����������ʾ");// TODO: handle exception
		}
		du.what("//input [@id='password']").sendKeys("abcde");
		wat.waitFor(3000);
		du.what(InterFRegister.regtitle).click();
		try {
			WebElement userpasswordLOWNUMerrorstring = du.what(InterFRegister.regformError);
			System.out.println(userpasswordLOWNUMerrorstring.getText());
			Assert.assertEquals(userpasswordLOWNUMerrorstring.getText(), "* ��������Ч������,����6 ���ַ�");
		} catch (Exception e) {
			System.out.println(e +" С��5λ����ʾ");// TODO: handle exception
		}  
		du.what("//input [@id='password']").sendKeys("!@#$%^&*(");
		wat.waitFor(3000);
		du.what(InterFRegister.regtitle).click();
		try {
			WebElement userpasswordLOWNUMerrorstring = du.what(InterFRegister.regformError);
			System.out.println(userpasswordLOWNUMerrorstring.getText());
			Assert.assertEquals(userpasswordLOWNUMerrorstring.getText(), "* ���������ֻ�Ӣ����ĸ");
		} catch (Exception e) {
			System.out.println(e +" ��Ӣ����������������ʾ");// TODO: handle exception
		} 
		du.what("//input [@id='password']").clear();
		du.what("//input [@id='password']").sendKeys(InterFRegister.userpasswordnumber);
		du.what("//input[@id='repassword']").sendKeys("0823letia");
		wat.waitFor(3000);
		du.what(InterFRegister.regtitle).click();
		try {
			WebElement userpasswordRECHKerrorstring = du.what(InterFRegister.regformError);
			System.out.println(userpasswordRECHKerrorstring.getText());
			Assert.assertEquals(userpasswordRECHKerrorstring.getText(), "* ������������벻һ��");
		} catch (Exception e) {
			System.out.println(e +" �ظ�ȷ�������������ʾ");// TODO: handle exception
		} 
	}
	
	@Test(priority = 5)
	public void chkRegverify(){
		//du.what(InterFRegister.getinreg).click();
		du.what("//input[@id='repassword']").clear();
		du.what("//input[@id='repassword']").sendKeys("0823letian");
		du.what(InterFRegister.regverifycode).sendKeys(" ");
		wat.waitFor(3000);
		du.what(InterFRegister.regtitle).click();
		try {
			WebElement userverifyCHKNULLerrorstring = du.what(InterFRegister.regformError);
			System.out.println(userverifyCHKNULLerrorstring.getText());
			Assert.assertEquals(userverifyCHKNULLerrorstring.getText(), "* ��������֤��");
		} catch (Exception e) {
			System.out.println(e +" ��֤��У�������ʾʧЧ");// TODO: handle exception
		} 
		du.what(InterFRegister.regverifycode).clear();
		du.what(InterFRegister.regverifycode).sendKeys("0823letia");
		wat.waitFor(3000);
		du.what(InterFRegister.regtitle).click();
		try {
			WebElement userverifyCHKerrorstring = du.what(InterFRegister.regformError);
			System.out.println(userverifyCHKerrorstring.getText());
			Assert.assertEquals(userverifyCHKerrorstring.getText(), "��֤�����벻��ȷ");
		} catch (Exception e) {
			System.out.println(e +" ��֤��У�������ʾʧЧ");// TODO: handle exception
		} 
	} 
	@Test(priority = 6)
	public void chkRegMobileverify(){
		//du.what(InterFRegister.getinreg).click();
		du.what(InterFRegister.regmobilecode).clear();
		du.what(InterFRegister.regmobilecode).click();
		wat.waitFor(3000);
		du.what(InterFRegister.regtitle).click();
		try {
			WebElement usermobileverifyCHKNUllerrorstring = du.what(InterFRegister.regformError);
			System.out.println(usermobileverifyCHKNUllerrorstring.getText());
			Assert.assertEquals(usermobileverifyCHKNUllerrorstring.getText(), "* �����������֤��");
		} catch (Exception e) {
			System.out.println(e +" ������֤��У�������ʾʧЧ");// TODO: handle exception
		} 	
		du.what(InterFRegister.regmobilecode).clear();
		du.what(InterFRegister.regmobilecode).sendKeys("08230823");
		wat.waitFor(3000);
		du.what(InterFRegister.regtitle).click();
		try {
			WebElement usermobileverifyCHKNUllerrorstring = du.what(InterFRegister.regformError);
			System.out.println(usermobileverifyCHKNUllerrorstring.getText());
			Assert.assertEquals(usermobileverifyCHKNUllerrorstring.getText(), "��֤���������");
		} catch (Exception e) {
			System.out.println(e +" ������֤��У�������ʾʧЧ");// TODO: handle exception
		} 	
	}
	@AfterClass
	public void quIt(){
		driver.close();
		driver.quit();
		
		
	}
}
