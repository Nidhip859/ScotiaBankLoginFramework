package tests;

import org.testng.annotations.Test;
import data.DataFile;
import pages.LoginPage;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	
	LoginPage lp = new LoginPage();
	DataFile df = new DataFile();
	
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  	lp.OpenBrowser();
		lp.OpenLoginPage();
  }

  @AfterMethod
  public void afterMethod() {
	  	lp.CloseBrowser();
  }
  
  @Test (priority = 1)
  public void loginEmailWithSpecialCharTest() throws InterruptedException {
	  	lp.Login(df.emailWithSpecialCharacter, df.wrongPassword);
		String expectedErr = df.specialCharErr;
		String actualErr = lp.ReadEmailError();		
		Assert.assertEquals(actualErr, expectedErr);
  }
  
  @Test (priority = 2)
  public void loginWithEmptyEmailTest() throws InterruptedException {
	  	lp.Login("",df.wrongPassword);
		String expectedErr = df.emptyEmailErr;
		String actualErr = lp.ReadEmailError();
		Assert.assertEquals(actualErr, expectedErr);
  }
  
  @Test (priority = 3)
  public void loginWithEmptyPasswordTest() throws InterruptedException {
	  	lp.Login(df.wrongEmail, "");
		String expectedErr = df.emptyPasswordErr;
		String actualErr = lp.ReadPasswordError();		
		Assert.assertEquals(actualErr, expectedErr);
  }
  
  @Test (priority = 4)
  public void loginWithwrongEmailPasswordTest() throws InterruptedException {
	  	lp.Login(df.wrongEmail,df.wrongPassword);
		String expectedErr = df.globalErr;
		String actualErr = lp.ReadGlobalError();
		Assert.assertEquals(actualErr, expectedErr);
  }
  
  
  
  

}
