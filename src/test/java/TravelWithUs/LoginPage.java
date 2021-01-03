package TravelWithUs;

import org.openqa.selenium.WebDriver;
import common.functions.WebSupport;

public class LoginPage {
	
	protected WebDriver driver;

	protected WebSupport webSupport;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void LoginWith(String email, String pass) {

		webSupport.clickOnElement(LoginSelector.signInBtn)
				.waitUntilPageContainsElement(LoginSelector.emailForm, 10)
				.sendKeysToElementToEdit(LoginSelector.emailForm, LoginData.EMAIL)
				.sendKeysToElementToEdit(LoginSelector.passWordForm, LoginData.PASSWORD)
				.clickOnElement(LoginSelector.loginBtn);

	}

}
