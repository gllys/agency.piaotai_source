package pagesbuilt;

public interface InterFLogin {
	//left menu
	String ticket 	= "//a[@id='drop_1']";
	String order 	= "//a[@id='drop_2']";
	String balance 	= "//a[@id='drop_3']";
	String ota 		= "//a[@id='drop_4']";
	String systom 	= "//a[@id='drop_5']";
	String message 	= "//a[@id='drop_6']";
	//left child menu 
//ticket
	String sale 	= "//li[1]/ul/li[1]"; String saleName     = "//table//thead//tr//th[8]";
	String group	= "//li[1]/ul/li[2]"; String groupName	  = "//table/thead/tr/th[8]";	
	String cart 	= "//li[1]/ul/li[3]"; String cartName	  = "//ul/li/h4[1]";
	String favourite= "//li[1]/ul/li[4]"; String favouriteName= "//ul/li/h4[1]";
//order
	
	




}
