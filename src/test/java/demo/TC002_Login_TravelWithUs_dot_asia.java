package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import TravelWithUs.LoginPage;
import common.functions.DriverFactory;
import common.functions.ReadExcel;
import common.functions.WebSupport;

public class TC002_Login_TravelWithUs_dot_asia {
	
	public static final Logger logger = LogManager.getLogger("DEMO");
	
	@Test
	public void testLoginTravelWithUs() throws Exception {
		WebDriver driver = DriverFactory.createDriver();
		driver.get("http://travelwithus.asia/");
		driver.manage().window().maximize();
		logger.info("GO TO travelwithus.asia ...");
		
		LoginPage page = new LoginPage(driver);
		String email = "dtruong@mailinator.com";
		String password = "0906307897";
		page.LoginWith(email,password);
		logger.info("LOGIN TO travelwithus.asia succeeded.");
		
		Thread.sleep(3000);
		driver.quit();
	}

}
