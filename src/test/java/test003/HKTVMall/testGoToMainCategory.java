package test003.HKTVMall;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hktvmall.www.PageObjects.MainHomepage;
import com.hktvmall.www.libs.Browser;
import com.hktvmall.www.libs.BrowserType;
import com.hktvmall.www.libs.ScreenShot;
import com.hktvmall.www.libs.Wait;
import com.hktvmall.www.libs.find;
import com.hktvmall.www.libs.objectStore;

public class testGoToMainCategory {
	private Browser br;
	private WebDriver driver;
	private MainHomepage mainhomepage;
	private find fd;
	private Wait wait;
	private ScreenShot scrshot;
	

@BeforeClass
public void intial(){
	br = new Browser(BrowserType.chrome);
	this.driver= br.webdriver;
	fd= new find(driver);
	wait = new Wait(driver);
	scrshot = new ScreenShot();
}

@Test
public void testmainCategory(){
	driver.get(objectStore.MainPageURL);
	mainhomepage = new MainHomepage(driver);
	mainhomepage.goToCategory();
	wait.waitForElementPresent(objectStore.subCategryHeader);
	wait.waitFortime(5000);
	Assert.assertTrue(fd.what(objectStore.subCategryHeader).getText().contains("Beauty Care"));
	scrshot.takeScreenShot("subCategory", driver);
	
}

@AfterClass
public void quit(){
	driver.quit();
}

}
