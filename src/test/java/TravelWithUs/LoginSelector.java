package TravelWithUs;

public class LoginSelector {
	public static String SignInBtn = "//a[normalize-space()='Sign In']";
	public static String EmailForm = "//input[@name='username']";
	public static String PassWordForm = "//label/following::input[@name='password'][contains(@onblur,'Enter password')]";
	public static String LoginBtn = "//button[text()='Login']";
}
