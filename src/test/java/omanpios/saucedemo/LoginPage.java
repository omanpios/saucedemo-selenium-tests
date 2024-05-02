package omanpios.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseTest {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	private By logoLocator = By.className("login_logo");
	private By usernameInputLocator = By.id("user-name");
	private By passwordInputLocator = By.id("password");
	private By errorMessageContainerLocator = By.cssSelector("[data-test='error']");
	private By loginButtonLocator = By.id("login-button");

	public void submitLoginForm(String username, String password) {
		type(usernameInputLocator, username);
		type(passwordInputLocator, password);
		click(loginButtonLocator);
	}

	public void clickOnLoginButton() {
		click(loginButtonLocator);
	}

	public String logoText() {
		return getText(logoLocator);
	}

	public String errorMessage() {
		return getText(errorMessageContainerLocator);
	}
}
