package pages;

import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import ui.SingletoneWebDriverTest;

public class StakeHolderManagementPage {
	public void gotoStakeHolderList() {
		Common common = new Common();
		
		common.getByXpath("//div[contains(text(),'Welcome to BInsight Manage')]");
		common.getByXpath("//span[contains(text(),' Stakeholder Management ')]").click();
		common.getByXpath("//span[contains(text(),' Stakeholder Information ')]").click();
	}
	
	public void createStakeHolder() {
		Common common = new Common();
		
		// Open create Form panel
		common.getByXpath("//mat-icon[contains(text(),'add')]").click();
		
		/* Fill-up the form */
		// Input name
		common.getById("mat-input-9").sendKeys("New Test User");
		
		// Select Gender
		common.getById("mat-select-value-17").click();
		common.getByXpath("//span[contains(text(),' Male ')]").click();
		
		// Select Country
		common.getById("mat-select-value-19").click();
		common.getByXpath("//span[contains(text(),' Sierra Leone ')]").click();
		
		// Select Geo Location
		common.getByCssSelector(".ng-tns-c30-52").click();
		common.getByXpath("//*[@id=\"mat-select-28-panel\"]/app-stl-tree/div/div/div/mat-form-field/div/div[1]/div[1]/mat-icon").click();
		common.getByXpath("//*[@id=\"mat-input-17\"]").sendKeys("Malal");
		common.getByXpath("//span[contains(text(),' Malal (Village) ')]").click();
		
		// Select Stakeholder Type
		common.getById("mat-select-value-21").click();
		common.getByXpath("//span[contains(text(),' YDC ')]").click();
		
		// Select Person Living with Disability Type
		common.getById("mat-select-value-25").click();
		common.getByXpath("//span[contains(text(),' No ')]").click();
		
		// input mobile number
		common.getByXpath("//*[@id=\"mat-input-10\"]").sendKeys("01721000000");
		
		// Click Save button
		common.getByXpath("//span[contains(text(),' Save ')]").click();
	}
	
	public void searchCreatedStakeHolder() {
		Common common = new Common();
		
		//Click Search button
		common.getByXpath("/html/body/app-root/layout/classy-layout/div/div[2]/mat-sidenav-container/mat-sidenav-content/app-stakeholders/div/app-table-wrapper/div/app-stl-table/div[2]/div/div[1]/div[2]/button[1]/span[1]/mat-icon")
			.click();
		common.getByXpath("//*[@placeholder='Search...']").sendKeys("New Test User");
		common.getByXpath("//*[@placeholder='Search...']").sendKeys(Keys.RETURN);
	}
}
