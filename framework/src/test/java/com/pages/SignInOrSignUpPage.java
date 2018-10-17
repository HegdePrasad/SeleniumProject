package com.pages;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.framework.configurations.Constants;
import com.framework.helpers.CommonLibrary;

public class SignInOrSignUpPage {
	
	WebDriver driver;
	CommonLibrary comLib = new CommonLibrary();
	
	@FindBy(xpath = "//div[contains(text(),'SIGN IN using Email')]")
	private WebElement signInUsingEmailLink;
	
	@FindBy(xpath = "//input[@id='email-mobile']")
	private WebElement emailIdTextField;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordTextField;
	
	@FindBy(xpath = "//button[@id='doSignin']")
	private WebElement signInButton;
	
	public SignInOrSignUpPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickSignInUsingEmailLink(){
		System.out.println("here");
		java.util.List<WebElement> f = driver.findElements(By.tagName("iframe"));
		System.out.println("here 1");
		System.out.println(f.size());
		for(int i=1; i<f.size(); i=i+1){
			System.out.println(i);
			driver.switchTo().frame(i);
			System.out.println("Ferer");
			if(comLib.isDisplayed(driver, signInUsingEmailLink)){
				System.out.println("Inside frame IF");
				signInUsingEmailLink.click();
			}else {
				System.out.println("Inside Frame Else");
				driver.switchTo().defaultContent();
				System.out.println("After switching to default content");
			}
		}	
	}
	
	public void signIn(String userName, String password){
		comLib.waitForElementVisisbility(driver, emailIdTextField, Constants.longWait);
		emailIdTextField.clear();
		emailIdTextField.click();
		emailIdTextField.sendKeys(userName);
		passwordTextField.clear();
		passwordTextField.click();
		passwordTextField.sendKeys(password);
		signInButton.click();
	}

}
