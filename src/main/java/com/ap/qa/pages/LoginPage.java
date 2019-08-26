package com.ap.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ap.qa.base.TestBase;
/**
 * 
 * @author Chintan
 *
 */
public class LoginPage extends TestBase {

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public WebElement ImageLogo() {
		return driver.findElement(By.id("header_logo"));
	}

	public WebElement AlreadyRegisteredMsg() {
		return driver.findElement(By.xpath("//form[@id='login_form']//h3[@class='page-subheading']"));
	}

	public WebElement emailID() {
		return driver.findElement(By.id("email"));
	}

	public WebElement password() {
		return driver.findElement(By.id("passwd"));
	}

	public WebElement SignInButton() {
		return driver.findElement(By.id("SubmitLogin"));
	}

	public WebElement error() {
		return driver.findElement(By.xpath("//div[@class='alert alert-danger']//ol"));
	}

	public WebElement ForgotPwLink() {
		return driver.findElement(By.xpath("//p[@class='lost_password form-group']//a"));
	}

}
