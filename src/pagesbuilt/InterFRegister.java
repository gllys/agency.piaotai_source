package pagesbuilt;

/**
 * 
 * @author Gllys Zhang
 *
 */
public interface InterFRegister {

	String local      			= "http://agency.test.demo.org.cn/";
	String remote 				= "http://www.piaotai.com";
	// REGAGENCY
	String regtitle 			= "//div/h4";
	String reguseraccount 		= "//input [@id='account']";
	String reguserpassword 		= "//input [@id='password']|//input[@id='repassword']";
	String regsubmit 			= "//div//button[@id='btn-reg']";
	String regmobile 			= "//input[@id='mobile']";
	String regverifycode 		= "//input[@id='verifycode']";
	String regmobilecode 		= "//input[@id='code']";
	String regturnback			= "//div/a[@class='btn btn-default btn-block']";
	String regverify 			= "0823";
	String regmobileverify 		= "0823";
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
	//resetpwd
	String reuseraccount 		= "//input[@id='reset_account']";
	String reuserveritycode		= "//input[@id='reset_code']";
	String regetcodebtn			= "//button[@id='sendCode']";
	String reuserpwd			= "//input[@id='reset_password']";
	String reuserchkpwd			= "//input[@id='reset_password_again']";
	String resubmitbtn			= "//button[@id='reset_pwd']";
	String returnbackbtn		= "//div/a[@class='btn btn-default btn-block']";
	//handle
	String agencywindowsname   	= "智慧旅游票务平台";
	//ERROR
	String regformError 		= "//div/div[@class='formErrorContent']";
	String reformError			= "//span[@id='chk_account']";
}
