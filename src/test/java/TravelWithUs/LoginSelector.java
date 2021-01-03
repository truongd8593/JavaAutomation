package TravelWithUs;

public class LoginSelector {
	public static final String homePage = "http://travelwithus.asia/";
	public static final String signInBtn = "//a[normalize-space()='Sign In']";
	public static final String emailForm = "//input[@name='username']";
	public static final String passWordForm = "//label/following::input[@name='password'][contains(@onblur,'Enter password')]";
	public static final String loginBtn = "//button[text()='Login']";
}
