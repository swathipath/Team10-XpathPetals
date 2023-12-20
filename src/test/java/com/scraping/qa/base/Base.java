package com.scraping.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	WebDriver driver;
	public Properties prop,dataprop;
	
	public  Base() {
		
		 prop=new Properties();
		File propFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\scraping\\qa\\config\\config.properties");
	    dataprop=new Properties();
		File dataPropFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\scraping\\qa\\testdata\\testdata.properties");
		
		try {
			FileInputStream fis1=new FileInputStream(propFile);	
			prop.load(fis1);
			
		} catch(Throwable e) {
			e.printStackTrace();
		}
		
		try {
	
		FileInputStream fis2=new FileInputStream(dataPropFile);
			dataprop.load(fis2);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public WebDriver intitalizeBrowserAndApplication(String browserName) {
		

		
		if(browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			driver=new ChromeDriver(options);
			//driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.Implicit_Wait_Time));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.Page_Load_Time));
		driver.get(prop.getProperty("url"));
		return driver;
	}

}

