package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.HomePagePOM1;
import com.training.pom.LoginPOMELearning;
import com.training.pom.MyCoursesPOM;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.pom.AdministrationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.trianing.waits.WaitTypes;

public class ComplexTestCasesTest {

	private WebDriver driver; 
	private String baseUrl; 
	private LoginPOMELearning loginPOMELearning;
	private AdministrationPOM administrationPOM;
	private ApachePOIExcelRead apachePOIExcelRead;
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
		loginPOMELearning = new LoginPOMELearning(driver);
		administrationPOM = new AdministrationPOM(driver);
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
	public void ELTC_073() {
		try {
		loginPOMELearning.sendUserName("admin");
		loginPOMELearning.sendPassword("admin@123");
		loginPOMELearning.clickLoginBtn(); 		
		administrationPOM.clickCourseCategoriesLnk();
		administrationPOM.clickAddCategoryIcon();
		administrationPOM.sendCategoryCode("BL");
		administrationPOM.sendCategoryName("Blended Learning");
		administrationPOM.clickCategoryRadioBtn();
		administrationPOM.clickCategoryRadioBtn();
		Assert.assertTrue(administrationPOM.getCategoryRadioBtn().isSelected(), "Category radio button not selected");
		administrationPOM.clickAddCategoryBtn();
		administrationPOM.clickAdminLnk();
		administrationPOM.clickCreateCourseLnk();
		administrationPOM.sendTitleValueTb("testing");
		administrationPOM.sendCodeValueTb("tes");
		administrationPOM.sendCategoryValueDd();
		administrationPOM.sendLanguageValueLb();
		administrationPOM.clickCreateCourseBtn();
		screenShot.captureScreenShot("First11");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
		@DataProvider
		public Object[][] getData() throws IOException
		{
			ApachePOIExcelRead apachePOIExcelRead = new ApachePOIExcelRead();
			List<List<Object>> data = ApachePOIExcelRead.getExcelContent("C:/Users/SarojiniEmekar/Desktop/Testing.xlsx");
	
			
			  Object[][] a = new Object[data.size()][3];
			  
			  for(int i = 0; i < data.size(); i++) { 
				  for(int j = 0; j < 3; j++) { 
					  a[i][j] =  (data.get(i)).get(j); 
					  System.out.println("Data Provider values: "+a[i][j]);
					  } 
				  }
			return a;
		}
		
		@Test(dataProvider="getData",enabled=false)
		public void ELTC_074(String categoryCodeTb, String categoryNameTb, String titleTb) {
			try {
			loginPOMELearning.sendUserName("admin");
			loginPOMELearning.sendPassword("admin@123");
			loginPOMELearning.clickLoginBtn(); 
			administrationPOM.clickCourseCategoriesLnk();
			administrationPOM.clickAddCategoryIcon();
			administrationPOM.sendCategoryCode(categoryCodeTb);
			administrationPOM.sendCategoryName(categoryNameTb);
			administrationPOM.clickCategoryRadioBtn();
			administrationPOM.clickCategoryRadioBtn();
			Assert.assertTrue(administrationPOM.getCategoryRadioBtn().isSelected(), "Category radio button not selected");
			administrationPOM.clickAddCategoryBtn();
			administrationPOM.clickAdminLnk();
			administrationPOM.clickCreateCourseLnk();
			administrationPOM.sendTitleValueTb(titleTb);
			administrationPOM.sendCodeValueTb("tes");
			administrationPOM.sendCategoryValueDd();
			administrationPOM.clickTeacherTbClear();
			//administrationPOM.sendTeacherTb("Manzoor");
			administrationPOM.sendLanguageValueLb();
			administrationPOM.clickCreateCourseBtn();
			screenShot.captureScreenShot("Second22");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	@DataProvider
	public Object[][] getData1() throws IOException
	{
		ApachePOIExcelRead apachePOIExcelRead = new ApachePOIExcelRead();
		List<List<Object>> data = ApachePOIExcelRead.getExcelContent("C:/Users/SarojiniEmekar/Desktop/Testing1.xlsx");

		
		  Object[][] a = new Object[data.size()][4];
		  
		  for(int i = 0; i < data.size(); i++) { 
			  for(int j = 0; j < 4; j++) { 
				  a[i][j] =  (data.get(i)).get(j); 
				  System.out.println("Data Provider values: "+a[i][j]);
				  } 
			  }
		return a;
	}
	
	@Test(dataProvider="getData1",enabled=true)
	public void ELTC_075(String categoryCodeTb, String categoryNameTb, String titleTb, String teacherTb) {
		try {
		loginPOMELearning.sendUserName("admin");
		loginPOMELearning.sendPassword("admin@123");
		loginPOMELearning.clickLoginBtn(); 
		administrationPOM.clickCourseCategoriesLnk();
		administrationPOM.clickAddCategoryIcon();
		administrationPOM.sendCategoryCode(categoryCodeTb);
		administrationPOM.sendCategoryName(categoryNameTb);
		administrationPOM.clickCategoryRadioBtn();
		administrationPOM.clickCategoryRadioBtn();
		Assert.assertTrue(administrationPOM.getCategoryRadioBtn().isSelected(), "Category radio button not selected");
		administrationPOM.clickAddCategoryBtn();
		administrationPOM.clickAdminLnk();
		administrationPOM.clickCreateCourseLnk();
		administrationPOM.sendTitleValueTb(titleTb);
		administrationPOM.sendCodeValueTb("tes");
		administrationPOM.sendCategoryValueDd();
		administrationPOM.clickTeacherTbClear();
		administrationPOM.sendTeacherTb(teacherTb);
		administrationPOM.sendLanguageValueLb();
		administrationPOM.clickCreateCourseBtn();
		screenShot.captureScreenShot("Second22");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
