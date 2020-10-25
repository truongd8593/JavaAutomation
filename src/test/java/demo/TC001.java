package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import common.functions.DriverFactory;
import common.functions.WebSupport;

public class TC001 {
	
	public static final Logger logger = LogManager.getLogger("DEMO");
	
	@Test
	public void testGoogleSearch() throws Exception {
		WebDriver driver = DriverFactory.createDriver();
		WebSupport webSupport = new WebSupport(driver);
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		String webTitle = "Google";
		Boolean resWebtTitle = false;
		resWebtTitle = webSupport.verifyWebTitle(webTitle);
		if (resWebtTitle == true)
			logger.info("The web title is verified as 'Google'");
		else
			logger.info("Wrong web title");
		logger.info("GO TO GOOGLE");
		webSupport.captureScreenshot(driver, "Screenshots/TC001_ss1.png");
		webSupport.sendKeysToElement("//*[@name='q']", "TMA Solutions");
		webSupport.captureScreenshot(driver, "Screenshots/TC001_ss2.png");
		webSupport.clickOnEnter("//*[@name='q']");
		Thread.sleep(1000);
		webSupport.captureScreenshot(driver, "Screenshots/TC001_ss3.png");
		webSupport.clickOnElement("//a[@href='https://www.tma.vn/']");
		Thread.sleep(3000);
		webSupport.captureScreenshot(driver, "Screenshots/TC001_ss4.png");
		driver.quit();
	}

}
