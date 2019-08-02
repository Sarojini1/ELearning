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

import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.HomePagePOM1;
import com.training.pom.MyCoursesPOM;
import com.training.pom.LoginPOMELearning;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.trianing.waits.WaitTypes;

public class MediumTestCasesTest {
	private WebDriver driver; 
	private String baseUrl; 
	private HomePagePOM1 homePagePOM1; 
	private MyCoursesPOM myCoursesPOM;
	private LoginPOMELearning loginPOMELearning;
	private static Properties properties; 
	private ScreenShot screenShot; 
	private GenericMethods genericMethods;
	private WaitTypes types;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		homePagePOM1 = new HomePagePOM1(driver); 
		myCoursesPOM = new MyCoursesPOM(driver);
		loginPOMELearning = new LoginPOMELearning(driver);
		genericMethods = new GenericMethods(driver);
		WaitTypes types = new WaitTypes(driver);
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
		/*homePagePOM.clickMyCoursesBtn();
		homePagePOM.clickCourseCatalogBtn();
		homePagePOM.sendSearchTb("Automation");
		homePagePOM.clickSearchBtn();
		homePagePOM.clickSubscribeBtn();*/		
		myCoursesPOM.clickCourseImg();
		Assert.assertTrue(myCoursesPOM.getDetailsOfSubCoursesSize()>0);
		homePagePOM1.clickAssignmentsIcon();
		Assert.assertTrue(homePagePOM1.getDetailsOfAssigntSize()>0);
		homePagePOM1.clickAssignmentLink();
		homePagePOM1.clickUploadAssigntBtn();
		screenShot.captureScreenShot("First1");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=1)
	public void loginPassTest1() {
		try {
		loginPOMELearning.sendUserName("Sarojini");
		loginPOMELearning.sendPassword("jayarani");
		loginPOMELearning.clickLoginBtn();
		Assert.assertTrue(myCoursesPOM.getCoursesSize()>0);
		/*homePagePOM.clickMyCoursesBtn();
		homePagePOM.clickCourseCatalogBtn();
		homePagePOM.sendSearchTb("Automation");
		homePagePOM.clickSearchBtn();
		homePagePOM.clickSubscribeBtn();*/
		myCoursesPOM.clickSubscribedCourseImg1();
		Assert.assertTrue(myCoursesPOM.getDetailsOfSubCoursesSize()>0);
		homePagePOM1.clickForumsIcon();
		Assert.assertTrue(homePagePOM1.getDetailsOfGroupsSize()>0);
		homePagePOM1.clickAssignedGroupNameLnk();
		homePagePOM1.clickCreateThread();
		boolean flag2 = homePagePOM1.getcreateThreadDeatils().contains("Create thread");
		System.out.println("create thread run successfully: "+flag2);
		Assert.assertTrue(flag2, "Create Thread details are not displayed");
		homePagePOM1.sendTitleTb("test");
		homePagePOM1.sendTextTb("need help");
		homePagePOM1.clickCreateThreadBtn();
		boolean flag3 = homePagePOM1.getMsgText1().contains("The new thread has been added");
		Assert.assertTrue(flag3, "new thread added message is not displayed");
		homePagePOM1.clickRplyToThisMsgBtn();
		homePagePOM1.sendRplyTextTb("take google help");
		homePagePOM1.clickRplyToThisMsgBtn1();
		boolean flag4 = homePagePOM1.getReplyMsgText().contains("The reply has been added");
		Assert.assertTrue(flag4, "Reply added message is not displayed");
		screenShot.captureScreenShot("Second2");
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test(enabled=false)
	public void loginPassTest2() {
		try {
		loginPOMELearning.sendUserName("Sarojini");
		loginPOMELearning.sendPassword("jayarani");
		loginPOMELearning.clickLoginBtn();
		Assert.assertTrue(myCoursesPOM.getCoursesSize()>0);
		/*homePagePOM.clickMyCoursesBtn();
		homePagePOM.clickCourseCatalogBtn();
		homePagePOM.sendSearchTb("Automation");
		homePagePOM.clickSearchBtn();
		homePagePOM.clickSubscribeBtn();*/
		myCoursesPOM.clickSubscribedCourseImg1();
		Assert.assertTrue(myCoursesPOM.getDetailsOfSubCoursesSize()>0);
		homePagePOM1.clickGroupsIcon();
		Assert.assertTrue(homePagePOM1.getDetailsOfGroupsSize()>0);
		homePagePOM1.clickAssignedGroupNameLnk();
		homePagePOM1.clickChatIcon();
		screenShot.captureScreenShot("Third");
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
