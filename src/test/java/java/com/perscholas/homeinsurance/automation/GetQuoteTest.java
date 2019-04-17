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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.perscholas.homeinsurance.dao.OracleConnection;

public class GetQuoteTest 
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
		@Test		//THIS TEST IS CURRENTLY UNDER CONSTRUCTION
		public void getQuoteTest() throws IOException
		{
			assumeTrue(databaseIsOnline);
			
			driver.manage().window().maximize();
			driver.get("http://localhost:8080//loginregistration/");
			
			WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > form > div:nth-child(1) > input[type=\"text\"]")));
			userName.sendKeys("123");
			
			assertTrue(driver.getTitle().equals("Login Page"));
			
			WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > form > div:nth-child(2) > input[type=\"PASSWORD\"]")));
			password.sendKeys("12345678");
			
			takeScreenShot(driver);
			
			WebElement loginBtn = driver.findElement(By.cssSelector("body > form > div:nth-child(3) > input[type=\"submit\"]"));
			builder.moveToElement(loginBtn).perform();
			loginBtn.click();
			
			WebElement getQuoteBtn = driver.findElement(By.cssSelector("body > div:nth-child(8) > form > span > b > input[type=\"submit\"]"));
			builder.moveToElement(getQuoteBtn).perform();
			getQuoteBtn.click();
											
			takeScreenShot(driver);
			
			assertTrue(driver.getTitle().equals("Location"));
			
			Select residenceType = new Select(driver.findElement(By.name("residenceType")));
			residenceType.selectByVisibleText("Single-Family Home");
			
			WebElement addressLine1 = driver.findElement(By.name("addressLine1"));
			addressLine1.sendKeys("7600 W Test rd");
			
			WebElement city = driver.findElement(By.name("city"));
			city.sendKeys("Test City");
			
			WebElement locationState = driver.findElement(By.name("locationState"));
			locationState.sendKeys("Texas");
			
			WebElement zipCode = driver.findElement(By.name("zipCode"));
			zipCode.sendKeys("75214");
			
			Select residenceUse = new Select(driver.findElement(By.name("residenceUse")));
			residenceUse.selectByVisibleText("Primary");
			
			takeScreenShot(driver);
			
			WebElement continueBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > form > div:nth-child(8) > p > input[type=\"submit\"]")));
			builder.moveToElement(continueBtn).perform();
			continueBtn.click();
			
			//WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("marketValue")));
			//firstName.sendKeys("25000");
			
			assertTrue(driver.getTitle().equals("Property Information"));

			takeScreenShot(driver);
			
			WebElement marketValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > form > div:nth-child(1) > p > input[type=\"number\"]")));
			marketValue.sendKeys("175500");
			
			WebElement yearBuilt = driver.findElement(By.cssSelector("body > form > div:nth-child(2) > p > input[type=\"number\"]"));
			yearBuilt.sendKeys("2003");
			
			WebElement squareFootage = driver.findElement(By.cssSelector("body > form > div:nth-child(3) > p > input[type=\"number\"]"));
			squareFootage.sendKeys("4700");
			
			Select dwellingType = new Select(driver.findElement(By.name("dwellingType")));
			dwellingType.selectByVisibleText("1 Story");
			
			Select roofMaterial = new Select(driver.findElement(By.name("roofingMaterial")));
			roofMaterial.selectByVisibleText("Concrete");
			
			Select garageType = new Select(driver.findElement(By.name("garageType")));
			garageType.selectByVisibleText("Attached");
			
			Select fullBaths = new Select(driver.findElement(By.name("fullBaths")));
			fullBaths.selectByVisibleText("1");
			
			Select halfBaths = new Select(driver.findElement(By.name("halfBaths")));
			halfBaths.selectByVisibleText("1");
			
			WebElement pool = driver.findElement(By.cssSelector("body > form > div:nth-child(9) > p > input[type=\"radio\"]:nth-child(4)"));
			pool.click();
			
			takeScreenShot(driver);
			
			driver.findElement(By.cssSelector("body > form > div:nth-child(10) > p > input[type=\"submit\"]")).click();
			
			
			takeScreenShot(driver);
			
			
			WebElement logoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#\\34")));
			assertTrue(driver.getTitle().equals("Coverage Details"));
			builder.moveToElement(logoutBtn).perform();
			logoutBtn.click();
			
			assertTrue(driver.getTitle().equals("Login Page"));
			
			takeScreenShot(driver);
			
		}
		
		
		private void takeScreenShot(WebDriver driver) throws IOException 
		{
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("target\\Screenshots\\" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd_HH.mm.ss.SSS")) + ".png"));
		}

	}

