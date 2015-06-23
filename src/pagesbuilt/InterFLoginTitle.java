package pagesbuilt;
/**
 * 
 * @author gllys
 * @see    agency登录后上方titlesxpath,从左至右顺序
 * ?+Name作确认使用
 */
public interface InterFLoginTitle {
	String Msg 		= "//*[@id='pull-right']/div[1]/a";
	String MsgName 	= "//*[@id='mainpanel']/div/ul/li[1]";
	String Cart		= "//*[@id='pull-right']/div[2]/a/span";
	String CartName = "//*[@id='mainpanel']/div/div/div[1]/ul/li[1]/h4";
	String Fav		= "//*[@id='pull-right']/div[3]/a";
	String FavName 	= "//*[@id='mainpanel']/div[1]/div[1]/div[1]/ul/li[1]/h4";
	String Work		= "//*[@id='pull-right']/div[4]/a";
	String WorkName = "//*[@id='mainpanel']/div/div[1]/div[1]/div/table/tbody/tr[1]/th";
	String Help 	= "//*[@id='pull-right']/div[5]/a";
	String HelpName = "//*[@id='mainpanel']/div/div/div/div/div[1]/h4";
	String Exit		= "//*[@id='pull-right']/div[6]/a";
	String ExitName = "//div/input[@id='name']";
	}
