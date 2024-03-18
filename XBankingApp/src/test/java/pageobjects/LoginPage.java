package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	public String homePageTitle = "Guru99 Bank Manager HomePage";

	@FindBy(xpath = "//input[@name = 'uid']")
	WebElement usernameInputBox;
	@FindBy(xpath = "//input[@name = 'password']")
	WebElement passwordInputBox;
	@FindBy(xpath = "//input[@name = 'btnLogin']")
	WebElement loginButton;
	@FindBy(xpath = "//input[@name = 'btnReset']")
	WebElement resetButton;

	public void setUserName(String userName) {
		usernameInputBox.sendKeys(userName);
	}

	public void setPassword(String password) {
		passwordInputBox.sendKeys(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public void clickResetButton() {
		resetButton.click();
	}

}
