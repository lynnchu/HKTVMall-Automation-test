package test002.HKTVMall;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import com.hktvmall.www.PageObjects.LoginPage;
import com.hktvmall.www.libs.Browser;
import com.hktvmall.www.libs.BrowserType;
import com.hktvmall.www.libs.Wait;
import com.hktvmall.www.libs.find;
import com.hktvmall.www.libs.getCsvData;
import com.hktvmall.www.libs.objectStore;

public class TestLoginFailed {
	private Browser br;
	private WebDriver driver;
	private LoginPage loginPage;
	private getCsvData getCsvdata;
	private String filepath;
	private find fd;
	//private Wait wait;
	private String getGlobalMessage;
	
	
@BeforeClass
public void intial(){
	br = new Browser(BrowserType.chrome);
	this.driver= br.webdriver;
	fd = new find(this.driver);
	//wait = new Wait(driver);
	
}

@Test
public void testLoginFailed(){
	filepath = System.getProperty("user.dir")+"\\TestCsvData\\data.csv";
	getCsvdata = new getCsvData(filepath);
	for(int i= 1; i<=3;i++){
		this.driver.get(objectStore.login_URL);
		loginPage = new LoginPage(this.driver);
		loginPage.login(getCsvdata.getTestData("email", "tc"+i),getCsvdata.getTestData("password", "tc"+i));
		if(i!=3){
			getGlobalMessage = loginPage.getGlobalMessages();
			Assert.assertTrue(getGlobalMessage.contains(getCsvdata.getTestData("errormessage", "tc"+i)));
			}
		else if(i==3){
			Assert.assertTrue(fd.what(objectStore.login_emailError).getText().contains(getCsvdata.getTestData("errormessage", "tc"+i)));
		}
	}
}

@AfterClass
public void quit(){
	driver.quit();
}

}
