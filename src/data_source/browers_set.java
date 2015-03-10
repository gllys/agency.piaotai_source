package data_source;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import data_source.BrowersType; //枚举初始化

public class browers_set {

	public WebDriver web_driver = null; // driver初始化
	private FirefoxProfile firefoxprofile = null;   //firefox初始化，firefox特有配置方式，使用profile配置
	private static DesiredCapabilities caps = null; // 浏览器设置初始化，IE，CHROME
	private String projectpath = "D:\\esclipse\\workspace\\Gllys_Automation"; // 项目路径配置，加接使用

	public browers_set(BrowersType browserstype) {
		switch (browserstype) // 枚举方法判断循环
		{
		case firefox:
			File firebug = new File(projectpath + "/tools/firebug-2.0.7.xpi");     // firefox特有方法加入特有项文件插件队列
			File firepath = new File(projectpath+ "/tools/FireXPath-0.9.7.1.xpi"); 
			firefoxprofile = new FirefoxProfile();                                 // 将设置的profile赋予新profile初始化
			try {
				firefoxprofile.addExtension(firebug);                              //加入插件，生效
				firefoxprofile.addExtension(firepath);                             //加入插件，生效
				firefoxprofile.setPreference("webdriver.accept.untrusted.certs", "true"); //浏览器配置
				firefoxprofile.setPreference("extensions.firebug.currentVersion", "2.0.7");//确认firebug当前版本防止提示冲突
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			web_driver = new FirefoxDriver(firefoxprofile);//将profile加载在driver句柄中
			web_driver.manage().window().maximize();//调用句柄后最大化窗口方法
			break;//跳出该条逻辑
		case ie:
			System.setProperty("webdriver.ie.driver", projectpath+ "/tools/IEDriverServer64.exe");
			caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS,false);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
			caps.setCapability("ignoreZoomSetting", true);
			web_driver = new InternetExplorerDriver(caps);
			web_driver.get("javascript:document.getElementById('overridelink').click();");
			web_driver.manage().window().maximize();
			break;
		case chrome:
			System.setProperty("webdriver.chrome.driver", projectpath+ "/tools/chromedriver.exe");
			caps = DesiredCapabilities.chrome();
			caps.setCapability("chrome.switches",Arrays.asList("--start-maximized")); // 最大化browser
			// capabilities.setCapability("chrome.switches",
			// Arrays.asList("--proxy-server=http://your-proxy-domain:4443"));
			//设置代理
			web_driver = new ChromeDriver(caps);
			web_driver.manage().window().maximize();
			break;

		}

	}

}
