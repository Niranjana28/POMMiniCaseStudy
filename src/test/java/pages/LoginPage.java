package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class LoginPage extends TestBase{
	
	WebDriverWait wait;
	
	@FindBy(id="login2")
	WebElement login;
	
	@FindBy(id="loginusername")
	WebElement username;
	
	@FindBy(id="loginpassword")
	WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-primary'][@onclick='logIn()']")
	WebElement Btn;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void login() throws InterruptedException {
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		login.click();
		username.sendKeys("Niranjana28");
		password.sendKeys("Niran@28");
		Btn.click();
		
	}
}
