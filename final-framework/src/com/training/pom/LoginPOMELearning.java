package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOMELearning {
	
	private WebDriver driver;
	
	public LoginPOMELearning(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	//login

	@FindBy(id="login")
	private WebElement userName; 

	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	@FindBy(id="password")
	private WebElement password;

	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}

	@FindBy(name="submitAuth")
	private WebElement loginBtn; 

	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}



}
