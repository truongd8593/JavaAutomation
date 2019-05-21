package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import TravelWithUs.LoginPage;
import common.functions.DriverFactory;
import common.functions.ReadExcel;
import common.functions.WebSupport;

public class TC003_CreateTrip_TravelWithUs_dot_asia {
	
	public static final Logger logger = LogManager.getLogger("DEMO");
	
	@Test
	public void testCreateTripTravelWithUs() throws Exception {
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
		
		//Create Trip
		driver.findElement(By.xpath("//a[text()='Create Trip']")).click(); 
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement trip_title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='title']")));
		trip_title.sendKeys("Luxurious Trip");
		driver.findElement(By.xpath("//input[@name='place']")).sendKeys("France");
		driver.findElement(By.xpath("//input[@placeholder='Start Date']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'datetimepicker') and contains(@style,'block')]//div[@class='datetimepicker-days']//th[contains(text(),'Today')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='End Date']")).click();	
		WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'datetimepicker') and contains(@style,'block')]//div[@class='datetimepicker-days']//th[contains(text(),'Today')]")));
		date.click();
		driver.findElement(By.xpath("//select[@id='members']")).sendKeys("2");
		driver.findElement(By.xpath("//button[text()='Submit'][@class='btn btn-success']")).click(); 
		Thread.sleep(1000);
		String alertMessage = driver.switchTo().alert().getText();	
		if (alertMessage == "A new trip has been created!") {
			driver.switchTo().alert().accept();
		}
		logger.info("Creating trip succeeded.");
		Thread.sleep(3000);
		driver.quit();
	}

}
