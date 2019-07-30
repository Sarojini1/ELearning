package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePagePOM {

	private WebDriver driver; 

	public HomePagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	//Simple TestCase01

	@FindBy(className="form-control")
	private WebElement searchTb; 
	
	public void sendSearchTb(String searchTb) {
		this.searchTb.clear(); 
		this.searchTb.sendKeys(searchTb);
	}

	@FindBy(className="input-group-btn")
	private WebElement searchBtn; 


	public void clickSearchBtn() {
		this.searchBtn.click(); 
	}

	@FindBy(xpath="//a[@title='Subscribe']")
	private WebElement subscribeBtn; 
	
	public void clickSubscribeBtn() {
		this.subscribeBtn.click(); 
	}
	
	
	@FindBys({@FindBy(className="block-title")})
	private List<WebElement> detailsOfCourses;
	
	public int getDetailsOfCoursesSize() {
		int size = this.detailsOfCourses.size();
		return size;
	}

	@FindBy(css=".alert.alert-info")
	private WebElement successMsg;
	
	public String getMsgText() {
		 return this.successMsg.getText();
	}
	
}
