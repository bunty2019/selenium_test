package TestNG;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class seleniumTest {

	
	WebDriver driver;
	@BeforeMethod
	public void launch() throws MalformedURLException {
		  //System.setProperty("webdriver.chrome.driver", "/Users/Singh/Selenium/chromedriver");
		  System.setProperty("webdriver.gecko.driver","/Users/Singh/Selenium/geckodriver");
		  
		  
		  //ChromeOptions Options= new ChromeOptions();
		  //Options.addArguments("--headless");
		  //WebDriver driver= new ChromeDriver(Options);
		  
		  FirefoxOptions Options= new FirefoxOptions();
		  Options.addArguments("--headless");
		  driver= new FirefoxDriver(Options);
		  //driver.get("http://localhost:3001/");
		  driver.get("http://ec2-3-87-48-82.compute-1.amazonaws.com:3001/");
		
		  //driver= new  FirefoxDriver();
		  
		  //driver.get("http://ec2-3-82-212-169.compute-1.amazonaws.com:3001");
		  //driver.get("http://localhost:3001");
 
		}
	
	@Test
	public void checkLogin() throws InterruptedException {
	  
		  driver.findElement(By.name("login")).sendKeys("devops");	
		  driver.findElement(By.name("password")).sendKeys("test");
		  driver.findElement(By.name("click")).click();
		  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		  String test= driver.findElement(By.name("test")).getText();
		  
		  assertEquals(test, "Login Succeeded");
		  System.out.println("Test Succeeded!!");


	 	  	  
	}
 
	@AfterMethod
	public void logout() {
	    driver.quit();
	}

}
