package pagesbuilt;

/**
 * 
 * @author Gllys Zhang
 *
 */
public interface InterFRegister {

	String local = "http://agency.test.demo.org.cn/";
	String remote = "http://www.piaotai.com";
	// REGAGENCY

	String useraccount = "//input [@id ='reg_account']";
	String userpassword = "//input [@id='reg_password']|//input[@id = 'reg_repassword']";
	String regsubmit = "//button[@id='btn_reg']";
	String mobile = "//input[@id='reg_mobile']";

	// AHEADAGENCY

	String getinreg = "//a [@class = 'new-account']";
	String dashpicture = "//div [@class='item active']";
	String dashtitle = "//div[@class='nav-inner']/a";
	
	/*********************************************************************************************************************/
	/**
	 * @author Gllys
	 */

	String mobilenumber = "13816219316";
	String useraccountnumber = "gllysleletian";
	String userpasswordnumber = "0823letian";
}
