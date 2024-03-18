package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import utilities.DataProviders;

public class TC_002_LoginTestDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void test_Login(String username, String password, String result) {
		LoginPage loginPage = new LoginPage(driver);
		log.info("***** TestCase Started *****");
		try {
			loginPage.setUserName(username);
			log.info("Entered Username");
			loginPage.setPassword(password);
			log.info("Entered Password");
			loginPage.clickLoginButton();
			log.info("Login Button Clicked");
			HomePage homePage = new HomePage(driver);
			boolean targetPage = homePage.isHomePagePresent();
			System.out.println(targetPage);
						
			if (result.equalsIgnoreCase("valid")) {
				if(targetPage == true) {
					log.info("Manager ID : " + homePage.getManagerId());
					Assert.assertTrue(true);
					homePage.clickOnLogoutButton();
					log.info("Test Case Pass");
				} else {
					log.fatal("Test Case Failed");
					Assert.assertTrue(false);
					
				}
			}
			if (result.equalsIgnoreCase("invalid")) {
				if(targetPage == true) {
					log.fatal("Test Case Failed");
					Assert.assertTrue(false);
					
				} else {
					log.info("Test Case Pass");
					Assert.assertTrue(true);	
				}
			}
			
			

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		log.info("***** Test Case Ended *****");
	}
}
