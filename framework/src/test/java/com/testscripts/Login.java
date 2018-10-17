package com.testscripts;

import org.testng.annotations.Test;

import com.framework.baseclass.BaseClass;
import com.pages.HomePage;
import com.pages.SignInOrSignUpPage;

public class Login extends BaseClass {
	
	@Test(description="Login to RedBus")
	public void login(){
		HomePage homepage = new HomePage(driver);
		homepage.clickRedBusIndiaButton();
		homepage.clickUserProfileIcon();
		homepage.clickSignInLink();
		SignInOrSignUpPage signInPage = new SignInOrSignUpPage(driver);
		signInPage.clickSignInUsingEmailLink();
		signInPage.signIn("prasad_46ph@yahoo.com", "Redbus@123");
		homepage.assertLoginSuccess();
		homepage.signOut();
		
		
	}
	
	
	
	
	
	
	

}
