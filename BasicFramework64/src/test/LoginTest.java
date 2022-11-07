package test;

import org.testng.annotations.Test;

import data.DataFile;
import pages.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	
	LoginPage lp = new LoginPage();
	DataFile df = new DataFile();
	
	
	 @BeforeMethod
	  public void beforeMethod() throws IOException {
			/*System.setProperty("webdriver.gecko.driver", "C:\\QA\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();*/
		 lp.OpenBrowser();
			/*driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=IZH01m5m5z0&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoiSVpIMDFtNW01ejAiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTY1NTA2NDg0MywiaWF0IjoxNjU1MDYzNjQzLCJqdGkiOiI5MjkzYWUwOC04ZmU0LTQxMWYtODNiZC1jYzJlNzUxMWM2ZDEiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.lEozhUNhZl8qdoR_u7fvJvddqs0_8e0t1VS6BD3WrulKZpCtXb9ZRDZnTFJO8pSrorY_msXDUIASQeM7gqonXmrij7aPzRS5Jf2_6F7RzqzugXJkemZ9k1mgw7vvPJ3bvfDZhCCNsB-fOmgdPYP1aPqmdWLozJWq6udW5BxRpzm0qG3R9ISsb79W7M8MNKviXwEHzihUh7JSBihc4XfT7KnQ7upwvA2LWWI8oVbQScdPyQULpdZSmHIv_KSUCSTiP_vJTdHPpfIGiMMR0tGkHUy0y0AMadmbxM7AVqYtAjcCu3UnuONzVt1RkGClEOzyUrkODIvdg_RiZYS_uN0r4A&preferred_environment=");
			*/
		 lp.OpenLoginPage();
	  }
		 
  @Test(priority = 1)
  public void loginEmailWithSpecialCharTest() throws InterruptedException {
	 
	/*  driver.findElement(By.id("usernameInput-input")).sendKeys("ndgbbbc%");
		driver.findElement(By.id("password-input")).sendKeys("hdbbdbb");
		driver.findElement(By.id("signIn")).click();
		Thread.sleep(3000); */
	  lp.Login(df.emailWithSpecialCharacter,df.wrongPassword);
		String expectedError = df.specialCharErr;
		String actualError = lp.ReadEmailError();//driver.findElement(By.id("UsernameTextField__errors-usernameInput")).getText();
		//System.out.println(actualError);
		lp.ReadEmailError();
		Assert.assertEquals(actualError, expectedError);
  }
  
  @Test(priority = 2)
  public void loginWithEmptyEmailTest() throws InterruptedException {
	  /*driver.findElement(By.id("password-input")).sendKeys("hdbbdbb");
		driver.findElement(By.id("signIn")).click();
		Thread.sleep(3000); */
	  lp.Login("",df.wrongPassword);
		String expectedError = df.emptyEmailErr;
		String actualError = lp.ReadEmailError();//driver.findElement(By.id("UsernameTextField__errors-usernameInput")).getText();
		//System.out.println(actualError);
		Assert.assertEquals(actualError, expectedError);
  }
  
  @Test(priority = 3)
  public void loginWithEmptyPasswordTest() throws InterruptedException {
	 /* driver.findElement(By.id("usernameInput-input")).sendKeys("ndgbbbc");
		driver.findElement(By.id("signIn")).click();
		Thread.sleep(3000); */
	  lp.Login(df.wrongEmail, "");
		String expectedError = df.emptyPasswordErr;
		String actualError = lp.ReadPasswordError();//driver.findElement(By.xpath("//span[contains(text(),'Please enter your password.')]")).getText();
		//System.out.println(actualError);
		Assert.assertEquals(actualError, expectedError);
  }
  @Test(priority = 4)
  public void loginEmailWithWrongEmailPasswordTest() throws InterruptedException {
	 
	 /* driver.findElement(By.id("usernameInput-input")).sendKeys("kdkdkdkkdkd");
		driver.findElement(By.id("password-input")).sendKeys("npnpnp");
		driver.findElement(By.id("signIn")).click();
		Thread.sleep(3000); */
	  lp.Login(df.wrongEmail,df.wrongPassword);
		String expectedError = df.globalErr;
		String actualError = lp.ReadGlobalError();//driver.findElement(By.id("globalError")).getText();
		//System.out.println(actualError);
		Assert.assertEquals(actualError, expectedError);
  }
  
 
  @AfterMethod
  public void afterMethod() {
	 // driver.quit();
	  lp.CloseBrowser();
  }

}// same scotia bank logIn test as selenium we have put (WebDriver drive;) at global level and put Assert to check equal string and add Jar file of selenium services
 