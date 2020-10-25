package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.functions.DriverFactory;
import common.functions.WebSupport;

public class TC001 {

	public static final Logger logger = LogManager.getLogger("DEMO");
	
	@Test
	public void testGoogleSearch() throws Exception {
		WebDriver driver = DriverFactory.createDriver();
		WebSupport webSupport = new WebSupport(driver);
		webSupport.navigateToUrl("https://www.google.com/")
				.maximizeBrowserWindow();
		Assert.assertTrue(webSupport.verifyWebTitle("Google"));
		webSupport.captureScreenshot(driver, "Screenshots/TC001_ss1.png")
				.sendKeysToElement("//*[@name='q']", "TMA Solutions")
				.captureScreenshot(driver, "Screenshots/TC001_ss2.png")
				.clickOnEnter("//*[@name='q']")
				.waitSomeSeconds(1)
				.captureScreenshot(driver, "Screenshots/TC001_ss3.png")
				.clickOnElement("//a[@href='https://www.tma.vn/']")
				.waitSomeSeconds(3)
				.captureScreenshot(driver, "Screenshots/TC001_ss4.png");
		driver.quit();
	}

}
