package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String homePageTitle = "Guru99 Bank Manager HomePage";

	@FindBy(xpath = "//a[text() = 'Log out']")
	WebElement logoutButton;
	
	@FindBy(xpath = "//tr[@class=\"heading3\"]") 
	WebElement managerIdLabel;
	
	
	
	public boolean isHomePagePresent() {
		if(logoutButton.isDisplayed())
		return true;
		return false;
	}

	public void clickOnLogoutButton() {
		logoutButton.click();
	}
	
	public String getManagerId() {
		return managerIdLabel.getText();
	}
}
