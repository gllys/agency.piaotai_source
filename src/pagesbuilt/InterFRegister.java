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
	String weixinerweima 		= "//span[@class=\"wh-pup\"]";
	String mobilenumber 		= "13816219316";
	String useraccountnumber 	= "gllysleletian";
	String userpasswordnumber 	= "0823letian";
	//handle
	String agencywindowsname   	= "智慧旅游票务平台";
	//ERROR
	String formError 			= "//div/div[@class='formErrorContent']";
}
