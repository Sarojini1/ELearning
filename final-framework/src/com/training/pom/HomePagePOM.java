package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePOM {

	private WebDriver driver; 

	public HomePagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	//login
	@FindBy(id="login")
	private WebElement userName; 

	@FindBy(id="password")
	private WebElement password;

	@FindBy(name="submitAuth")
	private WebElement loginBtn; 

	//TestCase01

	@FindBy(xpath="//li[@class='my-course ']")
	private WebElement myCoursesBtn; 

	@FindBy(xpath="//a[text()='Course catalog']")
	private WebElement courseCatalogBtn; 

	@FindBy(xpath="//input[@class='form-control']")
	private WebElement searchTb; 

	@FindBy(xpath="//div[@class='input-group-btn']")
	private WebElement searchBtn; 

	@FindBy(xpath="//a[@class='btn btn-success btn-sm']")
	private WebElement subscribeBtn; 

	//Testcase02

	@FindBy(xpath="//a[@title='Java selenium1']")
	private WebElement subscribedCourseLnk; 

	//Testcase03

	@FindBy(xpath="//li[@class='dropdown avatar-user']")
	private WebElement userDd; 
	
	@FindBy(id="logout_button")
	private WebElement logOutBtn;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}

	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}

	public void clickMyCoursesBtn() {
		this.myCoursesBtn.click(); 
	}

	public void clickCourseCatalogBtn() {
		this.courseCatalogBtn.click(); 
	}

	public void sendSearchTb(String searchTb) {
		this.searchTb.clear(); 
		this.searchTb.sendKeys(searchTb);
	}

	public void clickSearchBtn() {
		this.searchBtn.click(); 
	}

	public void clickSubscribeBtn() {
		this.subscribeBtn.click(); 
	}

	public void clickSubscribedCourseLnk() {
		this.subscribedCourseLnk.click();
	}

	public void clickUserDd() {
		this.userDd.click();
	}
	public void clickLogOutBtn() {
		this.logOutBtn.click();
	}
}
