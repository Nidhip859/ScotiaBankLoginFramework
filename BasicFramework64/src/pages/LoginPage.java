 package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	/*WebElement email = driver.findElement(By.id("usernameInput-input"));
	WebElement password = driver.findElement(By.id("password-input"));*/ //This will give you error don't use this
	
	@FindBy(id="usernameInput-input")
	public WebElement email;
	
	@FindBy(id="password-input")
	public WebElement password;
	
	@FindBy(id="signIn")
	public WebElement signInButton;
	
	@FindBy(id="globalError")
	public WebElement globalError;
	
	@FindBy(id="UsernameTextField__errors-usernameInput")
	public WebElement emailError;
	
	@FindBy(id="PasswordTextField__errors-password")
	public WebElement passwordError;
// if you want to add webElement globally then you need to use findBy
	
	public void OpenBrowser() throws IOException {
		/*System.setProperty("webdriver.gecko.driver", "C:\\QA\\SeleniumJars\\geckodriver.exe");
		driver = new FirefoxDriver(); */
		FileInputStream f = new FileInputStream("C:\\QA\\testing\\prop.properties");
		Properties prop = new Properties();
		prop.load(f);
		
		String browser = prop.getProperty("browser");
		
		String Browser = "Firefox";//Firefox,Chrome, Safari//read this value from Datafile, Excel, Propertise...
		if(Browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\QA\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(Browser.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\QA\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		}else {
			System.setProperty("webdriver.safari.driver", "C:\\QA\\SeleniumJars\\safaridriver.exe");
			driver = new SafariDriver();
		}
		PageFactory.initElements(driver,this); //initialization is mendatory to run this code
	}
	
	public void OpenLoginPage() {
		driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=IZH01m5m5z0&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoiSVpIMDFtNW01ejAiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTY1NTA2NDg0MywiaWF0IjoxNjU1MDYzNjQzLCJqdGkiOiI5MjkzYWUwOC04ZmU0LTQxMWYtODNiZC1jYzJlNzUxMWM2ZDEiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.lEozhUNhZl8qdoR_u7fvJvddqs0_8e0t1VS6BD3WrulKZpCtXb9ZRDZnTFJO8pSrorY_msXDUIASQeM7gqonXmrij7aPzRS5Jf2_6F7RzqzugXJkemZ9k1mgw7vvPJ3bvfDZhCCNsB-fOmgdPYP1aPqmdWLozJWq6udW5BxRpzm0qG3R9ISsb79W7M8MNKviXwEHzihUh7JSBihc4XfT7KnQ7upwvA2LWWI8oVbQScdPyQULpdZSmHIv_KSUCSTiP_vJTdHPpfIGiMMR0tGkHUy0y0AMadmbxM7AVqYtAjcCu3UnuONzVt1RkGClEOzyUrkODIvdg_RiZYS_uN0r4A&preferred_environment=");		
	}
	
	public void CloseBrowser() {
		driver.quit();
	}
	
	public void Login(String a, String b) throws InterruptedException {
		//driver.findElement(By.id("usernameInput-input")).sendKeys(a);
		email.sendKeys(a);
		//driver.findElement(By.id("password-input")).sendKeys(b);
		password.sendKeys(b);
		//driver.findElement(By.id("signIn")).click();
		signInButton.click();
		Thread.sleep(3000);
	}
	
	public String ReadEmailError() {
		String actualError = emailError.getText();//driver.findElement(By.id("UsernameTextField__errors-usernameInput")).getText();
		System.out.println(actualError);
		return actualError;
	}
	
	public String ReadPasswordError() {
		String actualError = passwordError.getText();//driver.findElement(By.id("PasswordTextField__errors-password")).getText();
		System.out.println(actualError);
		return actualError;
	}
	
	public String ReadGlobalError() {
		String actualError = globalError.getText();//driver.findElement(By.id("globalError")).getText();
		System.out.println(actualError);
		return actualError;
	}

}
