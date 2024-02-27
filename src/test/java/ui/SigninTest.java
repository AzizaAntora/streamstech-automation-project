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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import dataProvider.DataProviderTest;
import pages.Common;
import pages.SignInPage;
import pages.StakeHolderManagementPage;

public class SigninTest {

	WebDriver driver = SingletoneWebDriverTest.getInstance();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	@BeforeSuite
	public void startUp() {
		System.out.println("Started Automation");
	}

	@Test(priority = 1, dataProvider = "Signin", dataProviderClass = DataProviderTest.class)
	public void signInTest(String email, String password) {
		SignInPage signInPage = new SignInPage();
		signInPage.signIn(email, password);
	}
	
	@Test(priority = 2)
	public void GotoStakeholder() {
		Common common = new Common();
		common.switchTab();
		
		StakeHolderManagementPage stakeHolderPage = new StakeHolderManagementPage();
		stakeHolderPage.gotoStakeHolderList();
	}

	@Test(priority = 3)
	public void CreateStakeholder() {		
		StakeHolderManagementPage stakeHolderPage = new StakeHolderManagementPage();
		stakeHolderPage.createStakeHolder();
	}
	
	@Test(priority = 4)
	public void VerifyCreatedStakeholder() {		
		StakeHolderManagementPage stakeHolderPage = new StakeHolderManagementPage();
		stakeHolderPage.searchCreatedStakeHolder();
	}
	
	@AfterSuite
	public void cleanUp() {
		// driver.close();
		System.out.println("Finished Automation");
	}
}
