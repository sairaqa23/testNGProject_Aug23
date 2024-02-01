package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testDataProvider {

	WebDriver driver;
	By USER_NAME_FIELD = (By.xpath("//input[@id='user_name']"));
	By PASSWORD_FIELD = (By.xpath("//input[@id='password']"));
	By LOGIN_BUTTON_FIELD = (By.xpath("//button[@id='login_submit']"));

	@BeforeMethod
	public void init() {

		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://codefios.com/ebilling/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
    @DataProvider(name="loginData")
	public String[][] loginData() {

		String[][] data = new String[][] { 
			{ "demo@codefios.com", "abc123" }, 
			{ "demo5@codefios.com", "abc123" } };
		return data;
	}

	@Test(dataProvider= "loginData")
	public void testLogin(String username, String password) {
		driver.findElement(USER_NAME_FIELD).sendKeys(username);
		driver.findElement(PASSWORD_FIELD).sendKeys(password);
		driver.findElement(LOGIN_BUTTON_FIELD).click();

	}

}
