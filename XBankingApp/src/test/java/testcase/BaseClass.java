package testcase;


import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	Properties properties;
	Logger log;
	
	@BeforeClass
	@Parameters({"browser","url"})
	public void browsersetup(String browsername,String url) throws Exception {
		File file = new File(System.getProperty("user.dir")+"/Configuration/config.properties");
		FileInputStream fileInputStream = new FileInputStream(file);
		properties = new Properties();
		properties.load(fileInputStream);
		
		log = LogManager.getLogger();
		
		if (browsername.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
	
	}
	
	
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
