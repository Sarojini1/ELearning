package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.HomePagePOM;
import com.training.pom.LoginPOMELearning;
import com.training.pom.MyCoursesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class SimpleTestCasesTest {
	private WebDriver driver; 
	private String baseUrl; 
	private HomePagePOM homePagePOM; 
	private LoginPOMELearning loginPOMELearning;
	private MyCoursesPOM myCoursesPOM;
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
		loginPOMELearning = new LoginPOMELearning(driver);
		myCoursesPOM = new MyCoursesPOM(driver); 
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
			loginPOMELearning.sendUserName("Sarojini");
			loginPOMELearning.sendPassword("jayarani");
			loginPOMELearning.clickLoginBtn(); 
			myCoursesPOM.clickCourseCatalogBtn();
			Assert.assertTrue(homePagePOM.getDetailsOfCoursesSize()>0);
			homePagePOM.sendSearchTb("Automation");
			homePagePOM.clickSearchBtn();
			Assert.assertTrue(homePagePOM.getDetailsOfCoursesSize()>0);
			homePagePOM.clickSubscribeBtn();
			boolean flag = homePagePOM.getMsgText().contains("User Sarojini Emekar (Sarojini) has been registered to course");
			Assert.assertTrue(flag, "Course subscribe message is not met");
			screenShot.captureScreenShot("First");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test(enabled=false)
	public void loginPassTest1() {
		try {
			loginPOMELearning.sendUserName("Sarojini");
			loginPOMELearning.sendPassword("jayarani");
			loginPOMELearning.clickLoginBtn(); 
			Assert.assertTrue(myCoursesPOM.getCoursesSize()>0);
			myCoursesPOM.clickSubscribedCourseImg();
			Assert.assertTrue(myCoursesPOM.getDetailsOfSubCoursesSize()>0);
			myCoursesPOM.clickCourseDescriLnk();
			screenShot.captureScreenShot("Second");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority=1)
	public void logoutPassTest2() {
		try {
			loginPOMELearning.sendUserName("Sarojini");
			loginPOMELearning.sendPassword("jayarani");
			loginPOMELearning.clickLoginBtn(); 
			Assert.assertTrue(myCoursesPOM.getCoursesSize()>0);
			myCoursesPOM.clickUserDd();
			Assert.assertTrue(myCoursesPOM.getdetailsOfStudentSize()>0);
			myCoursesPOM.clickLogOutBtn();
			screenShot.captureScreenShot("Third");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
