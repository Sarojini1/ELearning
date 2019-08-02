package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.training.generics.GenericMethods;
import com.trianing.waits.WaitTypes;

public class HomePagePOM1 {

	private WebDriver driver;
	private WaitTypes types;
	private GenericMethods genericMethods;

	public HomePagePOM1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	//Medium Testcase01

	//click assignment icon

	@FindBy(xpath="//img[@title='Assignments']")
	private WebElement assignmentsIcon;

	public void clickAssignmentsIcon() {
		this.assignmentsIcon.click();
	}

	// Assert validation for assignment details displayed

	@FindBys({@FindBy(className="content")})
	private List<WebElement> detailsOfAssignt;

	public int getDetailsOfAssigntSize() {
		int size = this.detailsOfAssignt.size();
		return size;
	}
	// click Assignment link

	@FindBy(xpath="//a[text()='Testing Of ABC project']")
	private WebElement assignmentsLnk;

	public void clickAssignmentLink() {
		this.assignmentsLnk.click();
	}

	// click upload assignment button

	@FindBy(xpath="//a[@class='btn-toolbar']")
	private WebElement uploadAssigntBtn;

	public void clickUploadAssigntBtn() {
		this.uploadAssigntBtn.click();
	}

	//Medium Testcase02

	@FindBy(id="toolimage_2892")
	private WebElement forumsIcon;

	public void clickForumsIcon() {
		this.forumsIcon.click();
	}

	// Assert validation for Groups details displayed

	@FindBys({@FindBy(linkText = "Group 0002")})
	private List<WebElement> detailsOfGroups;

	public int getDetailsOfGroupsSize() {
		int size = this.detailsOfGroups.size();
		return size;
	}
	
	// click assigned group name
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
	
	// click create thread icon

	@FindBy(xpath="//img[@title='Create thread']")
	private WebElement createThread;

	public void clickCreateThread() {
		this.createThread.click();
	}
	
	// Assert validation for cReate thread details displayed
	
	@FindBy(xpath="//a[text()='Create thread']")
	private WebElement createThreadDetails;
	
	public String getcreateThreadDeatils() {
		return this.createThreadDetails.getText();
	}
	
	//send  title 

	@FindBy(name="post_title")
	private WebElement titleTb;

	public void sendTitleTb(String titleTb) {
		this.titleTb.clear();
		this.titleTb.sendKeys(titleTb);
	}

	// send text 
	
	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement textTb;
	
	@FindBy(tagName = "iframe")
	private WebElement frame;

	public void sendTextTb(String textTb) throws InterruptedException {
		//types.waitForElement(this.frame, 60);
		Thread.sleep(20000);
		driver.switchTo().frame(0);
		this.textTb.clear();
		this.waitForElement(this.textTb,30);
		this.textTb.click();
		this.textTb.sendKeys(textTb);
		driver.switchTo().defaultContent();
	}

	private void waitForElement(WebElement textTb2, int i) {
		// TODO Auto-generated method stub
		
	}

	// click create Thread button
	
	@FindBy(id="thread_SubmitPost")
	private WebElement createThreadBtn;

	public void clickCreateThreadBtn() {
		genericMethods= new GenericMethods(driver);
		genericMethods.scrollToView(this.createThreadBtn);
		this.createThreadBtn.click();
	}

	// Assert validation for new thread added message
	
	@FindBy(css=".alert.alert-success")
	private WebElement successMsg1;
	
	public String getMsgText1() {
		 return this.successMsg1.getText();
	}

	// click 'reply to this message' button
	@FindBy(xpath="//a[@title='Reply to this message']")
	private WebElement rplyToThisMsgBtn;

	public void clickRplyToThisMsgBtn() {
		this.rplyToThisMsgBtn.click();
	}
	
	// send text in reply
	
		@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
		private WebElement rplyTextTb;

		public void sendRplyTextTb(String rplyTextTb) throws InterruptedException {
			Thread.sleep(20000);
			driver.switchTo().frame(0);
			this.rplyTextTb.clear();
			this.waitForElement(this.rplyTextTb,30);
			this.rplyTextTb.click();
			this.rplyTextTb.sendKeys(rplyTextTb);
			driver.switchTo().defaultContent();
			
		}
		
	// click 'reply to this msg' btn
	
		@FindBy(id="thread_SubmitPost")
		private WebElement rplyToThisMsgBtn1;

		public void clickRplyToThisMsgBtn1() {
			this.rplyToThisMsgBtn1.click();
		}
		// Assert validation for reply added message
		
		@FindBy(css=".alert.alert-success")
		private WebElement replyMsg;
		
		public String getReplyMsgText() {
			 return this.replyMsg.getText();
		}
		
		//Medium Testcase03
		
		@FindBy(id="toolimage_2895")
		private WebElement groupIcon;
		
		public void clickGroupsIcon() {
			this.groupIcon.click();
		}
		
		// click chat icon
		
		@FindBy(xpath="//img[@title='Chat']")
		private WebElement chatIcon;
		
		public void clickChatIcon() {
			this.chatIcon.click();
		}
		
}
