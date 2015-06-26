package pagesbuilt;

/**
 * 
 * @author gllys
 * @see    agency登录前所有xpath,从左至右顺序,从上至下
 * ?+Name作确认使用
 */
public interface InterFRegister {

	String local      			= "http://agency.test.demo.org.cn/";
	String remote 				= "http://www.piaotai.com";
	// REGAGENCY
	String regtitle 			= "//div/h4";
	String reguseraccount 		= "//*[@id='account']";
	String reguserpassword 		= "//*[@id='password']";
	String regrepassword		= "//*[@id='repassword']";
	String regsubmit 			= "//*[@id='btn-reg']";
	String regmobile 			= "//*[@id='mobile']";
	String regverifycode 		= "//*[@id='verifycode']";
	String regmobilecode 		= "//*[@id='code']";
	String regturnback			= "//form[@id='RegisterForm']/div/div[2]/div/a";
	String regverify 			= "0823";
	String regmobileverify 		= "0823";
	String regpassword			= "0823letian";
	// AHEADAGENCY
	String getinreg 			= "//a [@class='new-account']";
	String dashpicture 			= "//div [@class='item active']";
	String dashtitle			= "//div[@class='nav-inner']/a";
	String weibo 				= "//div[@class='new-aside-sina']/a";
	String shouye				= "//div[@class='nav-inner']/a[1]";
	String piaotaijieshao		= "//div[@class='nav-inner']/a[2]";
	String ruheruzhu			= "//div[@class='nav-inner']/a[3]";
	String peitaoshebei			= "//div[@class='nav-inner']/a[4]";		
	String hezuozizhi			= "//div[@class='nav-inner']/a[5]";		
	String lianxiwomen 			= "//div[@class='nav-inner']/a[6]";	
	String weixin               = "//div[@class=\"new-aside-wh\"]";
	String weixinerweima 		= "//div/span[@class='wh-pup']";
	String mobilenumber 		= "13816219316";
	String useraccountnumber 	= "gllysleletian";
	String userpasswordnumber 	= "0823letian";
	String useraccount 			= "//div/input[@id='name']";
	String userpassword			= "//div/input[@id='password']";
	String dashswitchpic		= "//div[@id='carousel-example-generic']/ol/li/@class";
	String resetpwd				= "//div/a[@href='/site/reset/']";
	String userloginbtn			= "//div/button[@type='submit']";
	//dashboard
	String dashlogout			= "//a[@href='/site/logout']";
	String dashleftlogo			= "//div[@class='header-left']";
	String dashfirstpage		= "//li[@class='active']/descendant::*";
	String dashtoptitle			= "//div[@class='btn-group btn-group-option']/descendant::*";
	//resetpwd
	String reuseraccount 		= "//input[@id='reset_account']";
	String reuserveritycode		= "//input[@id='reset_code']";
	String regetcodebtn			= "//button[@id='sendCode']";
	String reuserpwd			= "//input[@id='reset_password']";
	String reuserchkpwd			= "//input[@id='reset_password_again']";
	String resubmitbtn			= "//button[@id='reset_pwd']";
	String returnbackbtn		= "//div/a[@class='btn btn-default btn-block']";
	//handle
	String agencywindowsname   	= "智慧旅游票务";
	//ERROR
	String regformError 		= "//div/div[@class='formErrorContent']";
	String reaccountformError	= "//span[@id='chk_account']";
	String repwdformError		= "//span[@id='chk_password']";
	String remessageformError	= "//span[@id='password_message']";
}
