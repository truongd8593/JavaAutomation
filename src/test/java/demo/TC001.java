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

import common.functions.DriverFactory;
import common.functions.ReadExcel;
import common.functions.WebSupport;

public class TC001 {
	
	public static final Logger logger = LogManager.getLogger("DEMO");

	@Test
	public void testGoogle() throws Exception {
		WebDriver driver = DriverFactory.createDriver();
		WebSupport webSupport = new WebSupport(driver);
		driver.get("https://www.google.com/");
		logger.info("GO TO GOOGLE");
		webSupport.sendKeysToElement("//*[@name='q']", "Selenium");
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.quit();
	}

}
