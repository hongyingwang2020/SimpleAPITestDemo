package com.testngplusmaven.mavenproject2018;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigationTest {
	WebDriver driver;
	  @Test
	  public void f() {
		  
		  String baseUrl;
		  baseUrl = "http://demo-store.seleniumacademy.com/";
		  
	      try {
	    	  driver.get(baseUrl);
	      }catch(WebDriverException e){
	    	  System.out.println("WebDriverException occured");
	      }
		  //Validate page title
		  Assert.assertEquals(driver.getTitle(), "Madison Island");
		  System.out.println("WebDriver starting");
		  
		  //Get the element
		  
		  System.out.println("Click account");
		  
		  WebElement accountField = driver.findElement(By.xpath("/html/body/div[1]/div[2]/header/div/div[2]/div/a/span[2]"));
		  accountField.click();
		  
		  
		  System.out.println("Enter login processing");
		  WebElement myaccountField = driver.findElement(By.xpath("/html/body/div[1]/div[2]/header/div/div[5]/div/ul/li[1]/a"));
		  myaccountField.click();
	  
	      //Login
		  System.out.println("Start login processing");
		  String email = "wanghongying2020@gmail.com";
		  String password ="Test@2020";
		  WebElement emailField = driver.findElement(By.id("email"));
		  emailField.sendKeys(email);
		  
		  WebElement passwordlField = driver.findElement(By.name("login[password]"));
		  passwordlField.sendKeys(password);
		  
		  System.out.println("Click login button");
		  WebElement loginPage = driver.findElement(By.id("send2"));
	      loginPage.click();
	      
	      Assert.assertEquals("Hello, hongying wang!", driver.findElement(By.className("hello")).getText());
	   
		/*
		 * WebElement pcloudyLink =
		 * driver.findElement(By.xpath("//a[@class='B1uW2d ellip PZPZlf']"));
		 * pcloudyLink.click();
		 * 
		 * WebElement loginPage = driver.findElement(By.xpath("//*[text()='Login']"));
		 * loginPage.click();
		 */
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		// set path of Chromedriver executable
		  System.out.println("Starting the browser session");
		  System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver");
		  //initialize new WebDriver session
		  
		  ChromeOptions options = new ChromeOptions();
		  // options.addArguments("--headless");
		  options.addArguments("--no-sandbox");
		  options.addArguments("--disable-dev-shm-usage");
		  options.addArguments("--verbose --whitelisted-ips=''");
		  
		  // driver = webdriver.Chrome(ChromeDriverManager(84.0.4147.30).install())
		  
		  driver = new ChromeDriver(options);
		  
		  //maximize the browser window
	      driver.manage().window().maximize();
		  //wait for a while
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  
	  }

	  @AfterMethod
	  public void afterMethod() {
		  // close and quit the browser
		  System.out.println("Closing the browser session");
		  driver.quit();
	  }


}
