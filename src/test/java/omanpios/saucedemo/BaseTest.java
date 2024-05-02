package omanpios.saucedemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	WebDriver driver;

	public BaseTest(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\java\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}

	public void click(By locator) {
		findElement(locator).click();
	}

	public String getText(By locator) {
		return findElement(locator).getText();
	}

	public void type(By locator, String text) {
		findElement(locator).sendKeys(text);
	}
	
	public void visit(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
}
