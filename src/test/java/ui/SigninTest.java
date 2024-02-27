package ui;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import dataProvider.DataProviderTest;

public class SigninTest {

	WebDriver driver = SingletoneWebDriverTest.getInstance();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	@Test(priority = 1, dataProvider = "Signin", dataProviderClass = DataProviderTest.class)
	public void signInTest(String email, String password) {

		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);

		driver.findElement(By.xpath(
				"/html/body/app-root/layout/empty-layout/div/div/auth-sign-in/div/div[1]/div/form/button/span[1]/span"))
				.click();

		System.out.println(driver.getTitle());

		String currentTitle = driver.getTitle();
		String expectedTitle = "Auth Client";
		Assert.assertEquals(currentTitle, expectedTitle);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/app-root/layout/classy-layout/div/div[2]/landing-home/div/div/div/ul/li/div")));

		driver.findElement(
				By.xpath("/html/body/app-root/layout/classy-layout/div/div[2]/landing-home/div/div/div/ul/li/div"))
				.click();

		Set<String> handles = driver.getWindowHandles();

		// Switch to the new tab
		for (String handle : handles) {
			if (!handle.equals(driver.getWindowHandle())) {
				driver.switchTo().window(handle);
				System.out.println(driver.getCurrentUrl());
				break;
			}
		}

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Welcome to BInsight Manage')]")));
		WebElement element = driver.findElement(By.xpath("//div[contains(text(),'Welcome to BInsight Manage')]"));
		System.out.println(element.getText());

		WebElement elementDropdown = driver
				.findElement(By.xpath("//span[contains(text(),' Stakeholder Management ')]"));
		elementDropdown.click();

	}

	@Test(priority = 2)
	public void CreateStakeholder() {

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[contains(text(),' Stakeholder Information ')]")));

		driver.findElement(By.xpath("//span[contains(text(),' Stakeholder Information ')]")).click();

		driver.findElement(By.xpath(
				"/html/body/app-root/layout/classy-layout/div/div[2]/mat-sidenav-container/mat-sidenav-content/app-stakeholders/div/app-table-wrapper/div/app-stl-table/div[2]/div/div[1]/div[2]/button[2]/span[1]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-input-9")));

		// Input name
		driver.findElement(By.id("mat-input-9")).sendKeys("My Test User");

		// Select Gender
		driver.findElement(By.id("mat-select-value-17")).click();
		driver.findElement(By.xpath("//span[contains(text(),' Male ')]")).click();

		// Select Country
		driver.findElement(By.id("mat-select-value-19")).click();
		driver.findElement(By.xpath("//span[contains(text(),' Sierra Leone ')]")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ng-tns-c30-52")));

		// Select Geo Location
		driver.findElement(By.cssSelector(".ng-tns-c30-52")).click();

		driver.findElement(By.xpath(
				"//*[@id=\"mat-select-28-panel\"]/app-stl-tree/div/div/div/mat-form-field/div/div[1]/div[1]/mat-icon"))
				.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mat-input-17\"]")));

		WebElement geoLocation = driver.findElement(By.xpath("//*[@id=\"mat-input-17\"]"));
		geoLocation.sendKeys("Malal");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[contains(text(),' Malal (Village) ')]")));

		driver.findElement(By.xpath("//span[contains(text(),' Malal (Village) ')]")).click();

		// Select Stakeholder Type
		driver.findElement(By.id("mat-select-value-21")).click();
		driver.findElement(By.xpath("//span[contains(text(),' YDC ')]")).click();

		// Select Person Living with Disability Type
		driver.findElement(By.id("mat-select-value-25")).click();
		driver.findElement(By.xpath("//span[contains(text(),' No ')]")).click();

		// input mobile number
		WebElement mobileNo = driver.findElement(By.xpath("//*[@id=\"mat-input-10\"]"));
		mobileNo.sendKeys("0172134567");

		// Click Save button
		driver.findElement(By.xpath("//span[contains(text(),' Save ')]")).click();
				
		//Click Search button
		
		driver.findElement(By.xpath("/html/body/app-root/layout/classy-layout/div/div[2]/mat-sidenav-container/mat-sidenav-content/app-stakeholders/div/app-table-wrapper/div/app-stl-table/div[2]/div/div[1]/div[2]/button[1]/span[1]/mat-icon")).click();
		
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@placeholder='Search...']")));

		WebElement searchBox = driver.findElement(By.xpath("//*[@placeholder='Search...']"));
		searchBox.sendKeys("My Test User");
		searchBox.sendKeys(Keys.RETURN);
		
//		String currentTitle = driver.getTitle();
//		String expectedTitle = "Auth Client";
//		Assert.assertEquals(currentTitle, expectedTitle);
		
		
	}

}
