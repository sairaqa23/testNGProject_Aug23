package variousConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class ParllelTest {
 
	public WebDriver driver;
	@Test
    public void ChromeTest() {
    	
       System.out.println("The thread ID for Chrome is "+ Thread.currentThread().getId());
       System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
       driver = new ChromeDriver();
      driver.get("https://www.yahoo.com/");
    
    }

  @Test
  public void EdgeTest() {
	  
	  System.out.println("The thread ID for edge is "+ Thread.currentThread().getId());
    System.setProperty("webdriver.edge.driver", "drivers\\msedgedriver.exe");
    driver = new EdgeDriver();
    driver.get("https://www.yahoo.com/");
  
  
  
  }

}
