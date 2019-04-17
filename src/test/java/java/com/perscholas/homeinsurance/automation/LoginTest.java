package com.perscholas.homeinsurance.automation;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.perscholas.homeinsurance.dao.OracleConnection;

public class LoginTest 
{
	private static WebDriver driver;			
	private static boolean databaseIsOnline;	
	private static Connection conn;
	private static OracleConnection orcl;
	private static Actions builder;
	private static String screenshotFolder;
	private static WebDriverWait wait;
	
	@BeforeClass
	public static void setUp()
	{
		System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
		
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		screenshotFolder = "Screenshots"+ LocalDateTime.now();
		builder = new Actions(driver);
		try
		{
			orcl = new OracleConnection();
			conn = orcl.getConnection();
			databaseIsOnline = true;
			conn.close();
		} catch (Exception e) 
		{
			databaseIsOnline = false;
			System.out.println("Unable to connect to database.");
		}
	}
	
	@AfterClass
	public static void tearDownClass() 
	{
		driver.close();
	}
	
	
		
		@Test
		public void loginTest() throws IOException
		{
			assumeTrue(databaseIsOnline);
			
			driver.manage().window().maximize();
			driver.get("http://localhost:8080//loginregistration/");
			
			WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > form > div:nth-child(1) > input[type=\"text\"]")));
			userName.sendKeys("1212");
			
			assertTrue(driver.getTitle().equals("Login Page"));
			
			WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > form > div:nth-child(2) > input[type=\"PASSWORD\"]")));
			password.sendKeys("12121212");
			
			takeScreenShot(driver);
			
			WebElement loginBtn = driver.findElement(By.cssSelector("body > form > div:nth-child(3) > input[type=\"submit\"]"));
			builder.moveToElement(loginBtn).perform();
			loginBtn.click();
			
			WebElement logoutBtn = driver.findElement(By.cssSelector("#\\34"));
			
			assertTrue(driver.getTitle().equals("Welcome Page"));
			
			builder.moveToElement(logoutBtn).perform();
			logoutBtn.click();
			
			assertTrue(driver.getTitle().equals("Login Page"));
			
			takeScreenShot(driver);
			
		}
		private void takeScreenShot(WebDriver driver) throws IOException 
		{
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("/target//Screenshots//" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd_HH.mm.ss.SSS")) + ".png"));
		}
}
