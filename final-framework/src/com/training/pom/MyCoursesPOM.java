package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class MyCoursesPOM {

	private WebDriver driver; 

	public MyCoursesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	//Simple TestCase01

	@FindBy(xpath="//a[text()='Course catalog']")
	private WebElement courseCatalogBtn; 

	public void clickCourseCatalogBtn() {
		this.courseCatalogBtn.click(); 
	}

	//Simple Testcase02

	// Clicking on subscribed course link
	@FindBy(xpath="//img[@title='ACCOUNT']")
	private WebElement subscribedCourseImg; 

	public void clickSubscribedCourseImg() {
		this.subscribedCourseImg.click();
	}

	//Assert validation for list of courses
	@FindBys({@FindBy(className="course-items-title")})
	private List<WebElement> lstOfCourses;

	public int getCoursesSize() {
		int size = this.lstOfCourses.size();
		return size;
	}

	// Assert validation for subscribed course details displayed

	@FindBys({@FindBy(className="content")})
	private List<WebElement> detailsOfSubCourses;

	public int getDetailsOfSubCoursesSize() {
		int size = this.detailsOfSubCourses.size();
		return size;
	}

	// Clicking on subscribed course link
	@FindBy(id="istooldesc_2643")
	private WebElement CourseDescriLnk; 

	public void clickCourseDescriLnk() {
		this.CourseDescriLnk.click();
	}

	//Simple Testcase03

	@FindBy(className="dropdown-toggle")
	private WebElement userDd; 

	public void clickUserDd() {
		this.userDd.click();
	}

	@FindBy(id="logout_button")
	private WebElement logOutBtn;

	public void clickLogOutBtn() {
		this.logOutBtn.click();
	}

	// Assert validation for subscribed course details displayed

	@FindBys({@FindBy(className="user-body")})
	private List<WebElement> detailsOfStudent;

	public int getdetailsOfStudentSize() {
		int size = this.detailsOfStudent.size();
		return size;
	}


	//Medium Testcase01

	//Clicking course displayed
	@FindBy(xpath="//img[@title='SeleniumE-learning']")
	private WebElement courseImg;

	public void clickCourseImg() {
		this.courseImg.click();

	}
	
	// Clicking on subscribed course link
		@FindBy(xpath="//img[@title='SeleniumE-learning']")
		private WebElement subscribedCourseImg1; 

		public void clickSubscribedCourseImg1() {
			this.subscribedCourseImg1.click();
		}
	
}
