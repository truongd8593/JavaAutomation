package TravelWithUs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void LoginWith(String email, String pass) {
		float timeoutInSeconds = (float) 10.0;
		this.driver.findElement(By.xpath(LoginSelector.SignInBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, (long) timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginSelector.EmailForm)));
		this.driver.findElement(By.xpath(LoginSelector.EmailForm)).sendKeys(email);
		this.driver.findElement(By.xpath(LoginSelector.PassWordForm)).sendKeys(pass);
		this.driver.findElement(By.xpath(LoginSelector.LoginBtn)).click();
	}

}
