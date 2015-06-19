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
	String ordermanage	= "//li[2]/ul/li[1]";String ordermanageName	="//div[@class=\"contentpanel\"]/div/div/ul/li[1]/h4";
	String refundorder  = "//li[2]/ul/li[2]";String refundorderName	="//*[@id='mainpanel']/div[1]/div[1]/div[1]/ul/li[1]/h4";
	String applycheck	= "//li[2]/ul/li[3]";String applycheckName	="//*[@id='mainpanel']/div/div[1]/div/ul/li[1]/h4";
//addup
	String addup		= "//li[3]/ul/li[1]";String addupbuyName	= "//*[@id='mainpanel']/div/ul/li[1]/a/strong";
//balance
	String shouldpayment= "//li[4]/ul/li[1]";String shouldpaymentName 	= "//*[@id='mainpanel']/div/div[1]/div[1]/ul/li[1]/h4";
	String platform		= "//li[4]/ul/li[2]";String platformName		= "//*[@id='mainpanel']/div/div[1]/div[1]/ul/li[1]/h4";
	String property		= "//li[4]/ul/li[3]";String propertyName		= "//*[@id='mainpanel']/div/div[1]/div[1]/ul/li[1]/h4";
	String blotter		= "//li[4]/ul/li[4]";String blotterName			= "//*[@id='mainpanel']/div/div[1]/div[1]/ul/li[1]/h4";
	String bankcard		= "//li[4]/ul/li[5]";String bankcardName		= "//*[@id='mainpanel']/div/div[1]/div[1]/ul/li[1]/h4";
//OTA
	String otamanager   = "//li[5]/ul/li";   String taobao				= "//ul[@role='tablist']//li[1]/a";String taobaoName = "//li[@class='pull-right']/div/a";
											 String meituan				= "//ul[@role='tablist']//li[4]/a";String meituanName= "//div[@class='panel-heading']/h4/a";
											 String wjd					= "//ul[@role='tablist']//li[3]/a";String wjdName    = "//div[@class='panel-heading']/h4/a";
											 String qunar				= "//ul[@role='tablist']//li[2]/a";String qunarName  = "//div[@class='panel-footer']/a";
//system-manager
											 
}
