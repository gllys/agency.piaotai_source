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
    	Assert.assertEquals(titlename.trim(), "创建分销商账号");
    	
    	
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
					"* 请输入用户名");
		} catch (Exception e) {
			System.out.println("没有生成空用户名下的提示 " + ErrorCode.nosource);// TODO:
																		// handle
																		// exception
		}
		// 验证默认状态下的submit提示操作
		du.what(InterFRegister.reguseraccount).clear();
		du.what(InterFRegister.reguseraccount).sendKeys("12345");
		wat.waitFor(3000);
		du.what(InterFRegister.regtitle).click();
		try {
			WebElement useraccountNUMerrorstring = du.what(InterFRegister.regformError);
			System.out.println(useraccountNUMerrorstring.getText());
			Assert.assertEquals(useraccountNUMerrorstring.getText(),
					"* 请输入有效的用户名,最少6 个字符");

		} catch (Exception e) {
			System.out.println("没有生成错误用户名长度(少于6位)下的提示 " + ErrorCode.nosource);// TODO:
																				// handle
																				// exception
		}
		// 验证输入少于6微的字符submit
		du.what(InterFRegister.reguseraccount).clear();
		du.what(InterFRegister.reguseraccount).sendKeys("!@#$%^^&&*()");
		wat.waitFor(3000);
		du.what(InterFRegister.regtitle).click();
		try {
			WebElement useraccountFORMerrorstring = du.what(InterFRegister.regformError);
			System.out.println(useraccountFORMerrorstring.getText());
			Assert.assertEquals(useraccountFORMerrorstring.getText(),
					"* 请输入有效的用户名，只能包含中文汉字、英文字母或数字");

		} catch (Exception e) {
			System.out.println("没有生成错误用户名符号下的提示 " + ErrorCode.nosource);// TODO:
																		// handle
																		// exception
		}
		// 错误的符号状态
		du.what(InterFRegister.reguseraccount).clear();
		du.what(InterFRegister.reguseraccount).sendKeys("gllysleletian");
		wat.waitFor(3000);
		du.what(InterFRegister.regsubmit).click();
		try {
			WebElement useraccountEXTerrorstring = du.what(InterFRegister.regformError);
			System.out.println(useraccountEXTerrorstring.getText());
			Assert.assertEquals(useraccountEXTerrorstring.getText(), "用户名已存在");

		} catch (Exception e) {
			System.out.println("没有生成用户名存在下的提示 " + ErrorCode.nosource);// TODO:
																		// handle
																		// exception
		}
		// 验证存在
	}

	@Test(priority = 3)
	public void chkRegMobile() {
		du.what(InterFRegister.reguseraccount).clear();
		// 只用2次所以不做方法
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
			Assert.assertEquals(usermobileNULLerrorstring.getText(), "* 请输入手机号");
		} catch (Exception e) {
			System.out.println(e + "空值下的手机号错误提示没有生成");// TODO: handle exception
		}
        du.what(InterFRegister.regmobile).clear();
        du.what(InterFRegister.regmobile).sendKeys(randomaccountNUM);
        wat.waitFor(3000);
        du.what(InterFRegister.regtitle).click();
        try {
        	WebElement usermobileTENNUMerrorstring = du.what(InterFRegister.regformError);
			System.out.println(usermobileTENNUMerrorstring.getText());
			Assert.assertEquals(usermobileTENNUMerrorstring.getText(), "* 请输入有效的手机号码");
		} catch (Exception e) {
		System.out.println(e +" 数字10位的错误手机号没有提示");	// TODO: handle exception
		}
        du.what(InterFRegister.regmobile).clear();
        du.what(InterFRegister.regmobile).sendKeys(randomaccount);
        wat.waitFor(3000);
        du.what(InterFRegister.regtitle).click();
        try {
        	WebElement usermobileSTRerrorstring = du.what(InterFRegister.regformError);
			System.out.println(usermobileSTRerrorstring.getText());
			Assert.assertEquals(usermobileSTRerrorstring.getText(), "* 请输入有效的手机号码");
		} catch (Exception e) {
		System.out.println(e +" 字符串");	// TODO: handle exception
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
			Assert.assertEquals(userpasswordNULLerrorstring.getText(), "* 请输入密码");
		} catch (Exception e) {
			System.out.println(e +" 空密码无提示");// TODO: handle exception
		}
		du.what("//input [@id='password']").sendKeys("abcde");
		wat.waitFor(3000);
		du.what(InterFRegister.regtitle).click();
		try {
			WebElement userpasswordLOWNUMerrorstring = du.what(InterFRegister.regformError);
			System.out.println(userpasswordLOWNUMerrorstring.getText());
			Assert.assertEquals(userpasswordLOWNUMerrorstring.getText(), "* 请输入有效的密码,最少6 个字符");
		} catch (Exception e) {
			System.out.println(e +" 小于5位无提示");// TODO: handle exception
		}  
		du.what("//input [@id='password']").sendKeys("!@#$%^&*(");
		wat.waitFor(3000);
		du.what(InterFRegister.regtitle).click();
		try {
			WebElement userpasswordLOWNUMerrorstring = du.what(InterFRegister.regformError);
			System.out.println(userpasswordLOWNUMerrorstring.getText());
			Assert.assertEquals(userpasswordLOWNUMerrorstring.getText(), "* 请输入数字或英文字母");
		} catch (Exception e) {
			System.out.println(e +" 非英文与数字输入无提示");// TODO: handle exception
		} 
		du.what("//input [@id='password']").clear();
		du.what("//input [@id='password']").sendKeys(InterFRegister.userpasswordnumber);
		du.what("//input[@id='repassword']").sendKeys("0823letia");
		wat.waitFor(3000);
		du.what(InterFRegister.regtitle).click();
		try {
			WebElement userpasswordRECHKerrorstring = du.what(InterFRegister.regformError);
			System.out.println(userpasswordRECHKerrorstring.getText());
			Assert.assertEquals(userpasswordRECHKerrorstring.getText(), "* 两次输入的密码不一致");
		} catch (Exception e) {
			System.out.println(e +" 重复确认密码错误无提示");// TODO: handle exception
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
			Assert.assertEquals(userverifyCHKNULLerrorstring.getText(), "* 请输入验证码");
		} catch (Exception e) {
			System.out.println(e +" 验证码校验错误提示失效");// TODO: handle exception
		} 
		du.what(InterFRegister.regverifycode).clear();
		du.what(InterFRegister.regverifycode).sendKeys("0823letia");
		wat.waitFor(3000);
		du.what(InterFRegister.regtitle).click();
		try {
			WebElement userverifyCHKerrorstring = du.what(InterFRegister.regformError);
			System.out.println(userverifyCHKerrorstring.getText());
			Assert.assertEquals(userverifyCHKerrorstring.getText(), "验证码输入不正确");
		} catch (Exception e) {
			System.out.println(e +" 验证码校验错误提示失效");// TODO: handle exception
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
			Assert.assertEquals(usermobileverifyCHKNUllerrorstring.getText(), "* 请输入短信验证码");
		} catch (Exception e) {
			System.out.println(e +" 短信验证码校验错误提示失效");// TODO: handle exception
		} 	
		du.what(InterFRegister.regmobilecode).clear();
		du.what(InterFRegister.regmobilecode).sendKeys("08230823");
		wat.waitFor(3000);
		du.what(InterFRegister.regtitle).click();
		try {
			WebElement usermobileverifyCHKNUllerrorstring = du.what(InterFRegister.regformError);
			System.out.println(usermobileverifyCHKNUllerrorstring.getText());
			Assert.assertEquals(usermobileverifyCHKNUllerrorstring.getText(), "验证码输入错误");
		} catch (Exception e) {
			System.out.println(e +" 短信验证码校验错误提示失效");// TODO: handle exception
		} 	
	}
	@AfterClass
	public void quIt(){
		driver.close();
		driver.quit();
		
		
	}
}
