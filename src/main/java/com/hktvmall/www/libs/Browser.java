//-------------Author:Lynn------------------
package com.hktvmall.www.libs;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Browser {
	public WebDriver webdriver;
	private DesiredCapabilities caps;
	public FirefoxProfile ffProfile;
	private String ProjectPath = System.getProperty("user.dir");

	
	
	public Browser(BrowserType browsertype){
		switch(browsertype){
		case ie:
			System.setProperty("webdriver.ie.driver", ProjectPath+"//webdriver//IEDriverServer.exe");
			caps= DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);//ǿ������һ��IE���Խ��
			caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");//��Inprivate Browsering
			caps.setCapability("ignoreZoomSetting", true);//���Դ������õĴ�С(Zoom)��ʹ��webdriverĬ�����ô�С
			//protected Mode  settings are not the same for all zones
			caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			webdriver = new InternetExplorerDriver(caps);
			webdriver.manage().window().maximize();		
			break;
		case firefox:
			File fireBug = new File(ProjectPath+"//Tools//firebug@software.joehewitt.com.xpi");//��ץȡ��Xpath������¼�Ƶ�Xpath��һ��ʱ
			File firePath = new File(ProjectPath+"//Tools//FireXPath@pierre.tholence.com.xpi");
			ffProfile = new FirefoxProfile();
			try{
			ffProfile.addExtension(fireBug);
			ffProfile.addExtension(firePath);
			ffProfile.setPreference("webdriver.accept.untrusted.certs", "true");//�ƹ�֤������
			ffProfile.setPreference("extensions.firebug.currentVersion", "2.0.2");//ȷ��firebugȷ��ҳ�棬�ƹ����firebugȷ��ҳ��
			}
			catch(IOException e){
				e.printStackTrace();
			}
			webdriver = new FirefoxDriver(ffProfile);
			webdriver.manage().window().maximize();
			break;
		case chrome:
			System.setProperty("webdriver.chrome.driver", ProjectPath+"//webdriver//chromedriver.exe");
			caps = DesiredCapabilities.chrome();
			caps.setCapability("chrome.switches", Arrays.asList("--start-maximized"));//���browser
			caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			//���ô���
			//caps.setCapability("chrome.switches", Arrays.asList("--proxy-server=http://your-proxy-domain:4443"));
			webdriver = new ChromeDriver(caps);
			webdriver.manage().window().maximize();
			break;
		}
	}

}
