package com.ap.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ap.qa.base.TestBase;
import com.ap.qa.pages.HomePage;
import com.ap.qa.pages.LoginPage;

/**
 * 
 * @author Chintan
 *
 */
public class HomePageTest extends TestBase {
	HomePage homePg;
	LoginPage loginPg;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		driver.get(prop.getProperty("url"));
		homePg = new HomePage();
	}

	@Test(priority = 1)
	public void HomePageTitleTest() {
		String title = homePg.validateHomePageTitle();
		Assert.assertEquals(title, "My Store");
	}
	
	@Test(priority = 1)
	public void ClickSignIn() throws Throwable {
		captureScreenShot();
		homePg.SignInButton().click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
