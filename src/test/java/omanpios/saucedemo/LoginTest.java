package omanpios.saucedemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	WebDriver driver;
	LoginPage loginPage;

	@Test
	public void verifyThatUsernameIsRequired() {
		loginPage.submitLoginForm("", "");
		assertEquals(loginPage.errorMessage(), "Epic sadface: Username is required");
	}

	@Test
	public void verifyThatPasswordIsRequired() {
		loginPage.submitLoginForm("standard_user", "");
		assertEquals(loginPage.errorMessage(), "Epic sadface: Password is required");
	}

	@Test
	public void verifyThatALockedOutUserCannotLogin() {
		loginPage.submitLoginForm("locked_out_user", "secret_sauce");
		assertEquals(loginPage.errorMessage(), "Epic sadface: Sorry, this user has been locked out.");
	}

	@Test
	public void verifyThatLogoIsPresent() {
		assertEquals(loginPage.logoText(), "Swag Labs");
	}

	@BeforeMethod
	public void beforeMethod() {
		loginPage = new LoginPage(driver);
		driver = loginPage.chromeDriverConnection();
		loginPage.visit("https://www.saucedemo.com/");
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
