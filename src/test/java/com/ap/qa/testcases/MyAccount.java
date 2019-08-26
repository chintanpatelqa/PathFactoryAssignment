package com.ap.qa.testcases;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ap.qa.base.TestBase;
import com.ap.qa.pages.HomePage;
import com.ap.qa.pages.LoginPage;
import com.ap.qa.pages.MyAccountPg;
import com.ap.qa.util.TestUtil;

/**
 * 
 * @author Chintan
 *
 */
public class MyAccount extends TestBase {
	private final static Logger LOGGER = Logger.getLogger(LoginPageMyStore.class.getName());
	HomePage homePg = new HomePage();
	LoginPage loginPg = new LoginPage();
	LoginPageMyStore myLoginPg = new LoginPageMyStore();
	MyAccountPg myAccoPg = new MyAccountPg();

	@BeforeMethod
	public void setUp() {
		initialization();
	}

	@DataProvider
	public Object[][] getInfo() {
		Object data[][] = TestUtil.getTestData("info");
		return data;
	}

	@Test(dataProvider = "getInfo", priority = 2)
	public void verifyInfo(String username, String password, String name) throws Throwable {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		loginPg.emailID().sendKeys(username);
		loginPg.password().sendKeys(password);
		loginPg.SignInButton().click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		LOGGER.info("Logged in to My Account");
		captureScreenShot();
		String title = myAccoPg.validateMyAccountPage();
		Assert.assertEquals(title, "My account - My Store");
		String NameUI = myAccoPg.Username().getText();
		Assert.assertEquals(NameUI, name);
		LOGGER.info("User Name Verified");

	}

	@AfterMethod
	public void tearDown() {
		myAccoPg.logout().click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		if (loginPg.validateLoginPageTitle().equals("Login - My Store")) {
			LOGGER.info("Successfully Logged Out");
		}
		driver.quit();
	}
}
