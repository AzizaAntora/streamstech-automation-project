package pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ui.SingletoneWebDriverTest;

public class Common {
	WebDriver driver = SingletoneWebDriverTest.getInstance();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public WebElement getByXpath(String path) {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(path)));
		return driver.findElement(By.xpath(path));
	}
	
	public WebElement getById(String path) {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id(path)));
		return driver.findElement(By.id(path));
	}
	
	public WebElement getByCssSelector(String path) {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(path)));
		return driver.findElement(By.cssSelector(path));
	}
	
	public void switchTab() {		
		Set<String> handles = driver.getWindowHandles();

		// Switch to the new tab
		for (String handle : handles) {
			if (!handle.equals(driver.getWindowHandle())) {
				driver.switchTo().window(handle);
				System.out.println(driver.getCurrentUrl());
				break;
			}
		}
	}
}
