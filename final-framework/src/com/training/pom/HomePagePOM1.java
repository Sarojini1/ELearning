package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePagePOM1 {

	private WebDriver driver;

	public HomePagePOM1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	//Testcase01

	@FindBy(xpath="//img[@title='SeleniumE-learning']")
	private WebElement forumIcon;

	public void clickForumIcon() {
		this.forumIcon.click();

	}

	@FindBy(xpath="//img[@title='Assignments']")
	private WebElement assignmentsIcon;

	public void clickAssignmentsIcon() {
		this.assignmentsIcon.click();
	}

	@FindBy(xpath="//a[text()='Testing Of ABC project']")
	private WebElement assignmentsLnk;

	public void clickAssignmentLink() {
		this.assignmentsLnk.click();
	}

	@FindBy(xpath="//a[@class='btn-toolbar']")
	private WebElement uploadAssigntBtn;

	public void clickUploadAssigntBtn() {
		this.uploadAssigntBtn.click();
	}
	
	//Testcase02
	
	@FindBy(id="toolimage_2895")
	private WebElement groupIcon;
	
	public void clickGroupIconBtn() {
		this.groupIcon.click();
	}
	
	@FindBy(xpath="//a[text()='Group 0002']")
	private WebElement assignedGroupName;
	
	public void clickAssignedGroupNameLnk() {
		this.assignedGroupName.click();
	}
	
	@FindBy(xpath="//img[@title='Group Forum']")
	private WebElement groupForum;
	
	public void clickGroupForum() {
	this.groupForum.click();
	}
	
	@FindBy(xpath="//img[@title='Create thread']")
	private WebElement createThread;
	
	public void clickCreateThread() {
		this.createThread.click();
	}
	
	@FindBy(name="post_title")
	private WebElement titleTb;
	
	public void sendTitleTb(String titleTb) {
		this.titleTb.clear();
		this.titleTb.sendKeys(titleTb);
	}
	
	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement textTb;
	
	public void sendTextTb(String textTb) {
		this.textTb.clear();
		this.textTb.sendKeys(textTb);
	}
	
	@FindBy(name="SubmitPost")
	private WebElement createThreadBtn;
	
	public void clickCreateThreadBtn() {
		this.createThreadBtn.click();
	}
	
}
