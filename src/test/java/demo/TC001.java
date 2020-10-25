package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.functions.DriverFactory;
import common.functions.WebSupport;

public class TC001 {

	public static final Logger logger = LogManager.getLogger("DEMO");

	private final String googleSearchInput = "//input[@name='q']";

	private final String  tmaSearchResult = "//a[@href='https://www.tma.vn/']";

	private final String googleHomePage = "https://www.google.com/";

	private final String googleHomePageTitle = "Google";
	
	@Test
	public void testGoogleSearch() throws Exception {
		WebDriver driver = DriverFactory.createDriver();
		WebSupport webSupport = new WebSupport(driver);
		webSupport.navigateToUrl(googleHomePage)
				.maximizeBrowserWindow();
		Assert.assertTrue(webSupport.verifyWebTitle(googleHomePageTitle));
		webSupport.captureScreenshot(driver, "Screenshots/TC001_ss1.png")
				.sendKeysToElement(googleSearchInput, "TMA Solutions")
				.captureScreenshot(driver, "Screenshots/TC001_ss2.png")
				.clickOnEnter(googleSearchInput)
				.waitSomeSeconds(1)
				.captureScreenshot(driver, "Screenshots/TC001_ss3.png")
				.clickOnElement(tmaSearchResult)
				.waitSomeSeconds(3)
				.captureScreenshot(driver, "Screenshots/TC001_ss4.png");
		driver.quit();
	}

}
