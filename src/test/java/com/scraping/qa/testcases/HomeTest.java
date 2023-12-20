package com.scraping.qa.testcases;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.scraping.qa.base.Base;
import com.scraping.qa.pages.HomePage;

public class HomeTest extends Base {
	
	WebDriver driver;
	
	
	public HomeTest() {
		
	super();
	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@BeforeMethod
	public void setUp() {
		
		driver=intitalizeBrowserAndApplication(prop.getProperty("browserName"));
	
	}
	
	@Test
	public void readingDataFromThePages() throws IOException, TimeoutException {
		
		HomePage homepage=new HomePage(driver);	
		homepage.iteratePages();
		
		
	}

}
