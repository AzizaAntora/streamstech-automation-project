package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletoneWebDriverTest {
	
	public static WebDriver driver;
	
	public static WebDriver getInstance() {
		
		if (driver == null) {
			driver = new ChromeDriver();
			driver.get("https://binsight.streamstech.com/");
			driver.manage().window().maximize();
			
		}
		return driver;
	}

}
