package TestNG;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
		  System.setProperty("webdriver.chrome.driver", "/home/ubuntu/selenium-website/chromedriver");
		  //System.setProperty("webdriver.gecko.driver","/Users/Singh/Selenium/geckodriver");
		  
		  
		  ChromeOptions Options= new ChromeOptions();
		  Options.addArguments("--headless");
		  WebDriver driver= new ChromeDriver(Options);
		  //driver.get("http://ec2-3-82-212-169.compute-1.amazonaws.com:3001");
		  driver.get("localhost:3001");
		   
		  /*
		
		  //String URL = "http://192.168.1.169:3001";
		  String URL = "http://ec2-3-82-212-169.compute-1.amazonaws.com::3001";
	 	  String Node = "http://192.168.1.169:4444/wd/hub";
	 		
	 	  //DesiredCapabilities cap = DesiredCapabilities.chrome();
	 	  DesiredCapabilities cap = DesiredCapabilities.firefox();

	 	  driver = new RemoteWebDriver(new URL(Node), cap);

		  //driver = new ChromeDriver();
		  driver.get(URL);
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		  */
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
