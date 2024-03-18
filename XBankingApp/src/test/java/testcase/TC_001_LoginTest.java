package testcase;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.*;

import pageobjects.HomePage;
import pageobjects.LoginPage;

public class TC_001_LoginTest extends BaseClass {

	@Test
	public void login() {
		LoginPage loginPage = new LoginPage(driver);

		log.info("****** Log Started ******");

		try {
			loginPage.setUserName(properties.getProperty("USERNAME"));
			log.info("Entered Usename");

			loginPage.setPassword(properties.getProperty("PASSWORD"));
			log.info("Entered Password");
			loginPage.clickLoginButton();
			log.info("Login Button Clicked");
			String actualTitle = driver.getTitle();
			HomePage homePage = new HomePage(driver);
			String expectedTitile = homePage.homePageTitle;

			if (expectedTitile.equals(actualTitle)) {
				log.info("Login Successful");
				AssertJUnit.assertTrue(true);
				log.info("Checking title of HomePage");
			} else {
				AssertJUnit.assertTrue(false);
			}
			// Assert.assertEquals(expectedTitile, actualTitle);
			
		} catch (Exception e) {
			AssertJUnit.fail();
			log.fatal("Test Failed");
		}
		
		log.info("****** Log Ended ******");
	}
}
