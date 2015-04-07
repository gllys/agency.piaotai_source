package pagesbuilt;
/**
 * 
 * @author Gllys Zhang
 *
 */
public interface InterFRegister {

//	REGAGENCY
	
	
	String useraccount = "//input [@id ='reg_account']";
	String userpassword = "//input [@id='reg_password']|//input[@id = 'reg_repassword']";
	String regsubmit = "//button[@id='btn_reg']";

	
//  URLAGENCY
	String local = "http://agency.test.demo.org.cn/";
	String getinreg = "//a [@class = 'new-account']";
	
	
	
}
