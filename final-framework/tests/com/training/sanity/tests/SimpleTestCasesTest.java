package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.HomePagePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class SimpleTestCasesTest {
	private WebDriver driver; 
	private String baseUrl; 
	private HomePagePOM homePagePOM; 
	private static Properties properties; 
	private ScreenShot screenShot; 


	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		homePagePOM = new HomePagePOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}

	@Test(enabled=false)
	public void loginPassTest() {
		try {
		homePagePOM.sendUserName("admin");
		homePagePOM.sendPassword("admin@123");
		homePagePOM.clickLoginBtn(); 
		homePagePOM.clickMyCoursesBtn();
		homePagePOM.clickCourseCatalogBtn();
		homePagePOM.sendSearchTb("Automation");
		homePagePOM.clickSearchBtn();
		homePagePOM.clickSubscribeBtn();
		screenShot.captureScreenShot("First");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=1)
	public void loginPassTest1() {
		try {
		homePagePOM.sendUserName("admin");
		homePagePOM.sendPassword("admin@123");
		homePagePOM.clickLoginBtn(); 
		homePagePOM.clickMyCoursesBtn();
		homePagePOM.clickSubscribedCourseLnk();
		screenShot.captureScreenShot("Second");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=2)
	public void logoutPassTest() {
		try {
		homePagePOM.sendUserName("admin");
		homePagePOM.sendPassword("admin@123");
		homePagePOM.clickLoginBtn(); 
		homePagePOM.clickUserDd();
		homePagePOM.clickLogOutBtn();
		screenShot.captureScreenShot("Third");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
