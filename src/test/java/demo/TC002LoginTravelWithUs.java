package demo;

import TravelWithUs.LoginData;
import TravelWithUs.LoginSelector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TravelWithUs.LoginPage;
import common.functions.DriverFactory;
import common.functions.WebSupport;

public class TC002LoginTravelWithUs {

    public static final Logger logger = LogManager.getLogger("DEMO");

	private WebSupport webSupport;

	private WebDriver driver;

	private LoginPage page;

    @BeforeTest
    public void testSetup() throws Exception {
        driver = DriverFactory.createDriver();
        webSupport = new WebSupport(driver);
		page = new LoginPage(driver);
    }

    @Test
    public void testLoginTravelWithUs() throws Exception {
        webSupport.navigateToUrl(LoginSelector.homePage)
				.maximizeBrowserWindow();
        logger.info("GO TO travelwithus.asia ...");
        page.LoginWith(LoginData.EMAIL, LoginData.PASSWORD);
        logger.info("LOGIN TO travelwithus.asia succeeded.");
        webSupport.waitSomeSeconds(3);
    }

	@AfterTest
	public void testTeardown() {
		driver.quit();
	}

}
