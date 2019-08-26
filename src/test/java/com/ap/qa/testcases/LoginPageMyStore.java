package com.ap.qa.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ap.qa.base.TestBase;
import com.ap.qa.pages.ForgotPwPg;
import com.ap.qa.pages.HomePage;
import com.ap.qa.pages.LoginPage;
import com.ap.qa.pages.MyAccountPg;
import com.ap.qa.util.TestUtil;

/**
 * 
 * @author Chintan
 *
 */
public class LoginPageMyStore extends TestBase {
	// LoginPage loginPg;
	LoginPage loginPg = new LoginPage();
	HomePage homePg = new HomePage();
	MyAccountPg myAccoPg = new MyAccountPg();
	ForgotPwPg forgotPg = new ForgotPwPg();
	String sheetName = "credentials";
	private final static Logger LOGGER = Logger.getLogger(LoginPageMyStore.class.getName());

	public LoginPageMyStore() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		driver.get(prop.getProperty("url"));
		homePg.SignInButton().click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void loginPageTitleTest() throws Throwable {
		String title = loginPg.validateLoginPageTitle();
		Assert.assertEquals(title, "Login - My Store");
		if (loginPg.ImageLogo().isDisplayed()) {
			LOGGER.info("Verified Image Logo");
			captureScreenShot();
		}
	}

	@DataProvider
	public Object[][] getAutomationTestData() {
		Object data[][] = TestUtil.getTestData("login");
		return data;
	}

	@Test(priority = 2, dataProvider = "getAutomationTestData")
	public void SignInPage(String username, String password) {
		String Msg = loginPg.AlreadyRegisteredMsg().getText();
		Assert.assertEquals(Msg, "ALREADY REGISTERED?");
		loginPg.emailID().sendKeys(username);
		loginPg.password().sendKeys(password);
		loginPg.SignInButton().click();
		try {
			String title = loginPg.validateLoginPageTitle();
			if (title.equals("Login - My Store")) {
				String error = loginPg.error().getText();
				LOGGER.info("Unable to Login: " + error);
			}
		} catch (Exception e) {
			String title = myAccoPg.validateMyAccountPage();
			if (title.equals("My account - My Store")) {
				LOGGER.info("Successfully Loged In");
			}
		}
	}

	@DataProvider
	public Object[][] getInfo() {
		Object data[][] = TestUtil.getTestData("info");
		return data;
	}

	@Test(priority = 3, dataProvider = "getInfo")
	public void ForgotPassword(String username, String password, String name) throws Throwable {
		loginPg.ForgotPwLink().click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		captureScreenShot();
		String title = forgotPg.validateForgotPageTitle();
		Assert.assertEquals(title, "Forgot your password - My Store");
		String ForgotMsg = forgotPg.ForgotTitle().getText();
		Assert.assertEquals(ForgotMsg, "FORGOT YOUR PASSWORD?");
		forgotPg.emailId().sendKeys(username);
		forgotPg.RetrivePw();
		forgotPg.RetrivePw().click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		captureScreenShot();
		String error = forgotPg.ConfirmationMsg().getText();
		LOGGER.info(error);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
