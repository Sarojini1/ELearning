package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generics.GenericMethods;

public class AdministrationPOM {

	private WebDriver driver; 
	private GenericMethods genericMethods;

	public AdministrationPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Click on 'Courses categories' link 
	@FindBy(linkText="Courses categories")
	private WebElement courseCategoriesLnk; 
	
	public void clickCourseCategoriesLnk() {
		this.courseCategoriesLnk.click();
	}
	
	// Click on Add Category Icon
	@FindBy(xpath="//img[@title='Add category']")
	private WebElement addCategoryIcon; 
	
	public void clickAddCategoryIcon() {
		this.addCategoryIcon.click();
	}
	
	// Click on course Category Code text box
	@FindBy(id="course_category_code")
	private WebElement categoryCodeTb; 
		
	public void sendCategoryCode(String categoryCodeTb) {
		this.categoryCodeTb.click();
		this.categoryCodeTb.clear();
		this.categoryCodeTb.sendKeys(categoryCodeTb);
	}
	

	@FindBy(id="course_category_name")
	private WebElement categoryNameTb; 
		
	public void sendCategoryName(String categoryNameTb) {
		this.categoryNameTb.click();
		this.categoryNameTb.clear();
		this.categoryNameTb.sendKeys(categoryNameTb);
	}
	
	@FindBy(name="auth_course_child")
	private WebElement categoryRadioBtn; 
	
	public void clickCategoryRadioBtn() {
		this.categoryRadioBtn.click();
	}
	
	public WebElement getCategoryRadioBtn() {
		return this.categoryRadioBtn;
	}
	
	@FindBy(id="course_category_submit")
	
	private WebElement addCategoryBtn; 
	public void clickAddCategoryBtn() {
		this.addCategoryBtn.click();
	}
	
	@FindBy(xpath="//a[@title='Administration']")
	
	private WebElement adminLnk; 
	public void clickAdminLnk() {
		this.adminLnk.click();
	}
	
	@FindBy(linkText="Create a course")
	private WebElement createCourseLnk; 
	public void clickCreateCourseLnk() {
		this.createCourseLnk.click();
	}
	
	@FindBy(id="update_course_title")
	private WebElement titleTb; 
	public void sendTitleValueTb(String titleTb) {
		this.titleTb.click();
		this.titleTb.clear();
		this.titleTb.sendKeys(titleTb);
	}
	
	@FindBy(id="visual_code")
	private WebElement codeTb; 
	
	public void sendCodeValueTb(String codeTb) {
		this.codeTb.click();
		this.codeTb.clear();
		this.codeTb.sendKeys(codeTb);
	}
	
	@FindBy(xpath="//button[@data-id='update_course_category_code']")
	private WebElement categoryDrpDwn;
	
	
	@FindBy(xpath="//span[text()='Blended Learning (BL)']")
	private WebElement categoryTb; 
	
	public void sendCategoryValueDd() {
		this.categoryDrpDwn.click();
		this.categoryTb.click();;
	}
	
	@FindBy(xpath="//span[@class='select2-selection__clear']")
	private WebElement teacherTbClear; 
	
	public void clickTeacherTbClear() {
		this.teacherTbClear.click();
	}
	
	@FindBy(xpath="//input[@placeholder='Please select an option']")
	private WebElement teacherTb; 
	
	public void sendTeacherTb(String teacherTb) {
		this.teacherTb.click();
		this.teacherTb.clear();
		this.teacherTb.sendKeys(teacherTb);	
	}
	//select[@id='course_teachers']
	@FindBy(xpath="//button[@data-id='update_course_course_language']")
	private WebElement languageDrpDwn;
	
	@FindBy(xpath="//span[text()='English']")
	private WebElement languageLb; 
	
	public void sendLanguageValueLb() {
		this.languageDrpDwn.click();
		this.languageLb.click();
	}
	
	
	@FindBy(id="update_course_submit")
	private WebElement createCourseBtn; 
	public void clickCreateCourseBtn() {
		this.createCourseBtn.click();
	}
}