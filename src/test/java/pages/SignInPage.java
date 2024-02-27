package pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import ui.SingletoneWebDriverTest;

public class SignInPage {
	
	public void signIn(String email, String password) {
		WebDriver driver = SingletoneWebDriverTest.getInstance();
		Common common = new Common();
		
		common.getById("email").sendKeys(email);
		common.getById("password").sendKeys(password);
		common.getByXpath("//span[contains(text(),'Sign in')]").click();

		System.out.println(driver.getTitle());

		String currentTitle = driver.getTitle();
		String expectedTitle = "Auth Client";
		Assert.assertEquals(currentTitle, expectedTitle);
		
		common.getByXpath("//p[contains(text(),'Admin')]").click();
	}
}
