package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class PurchasePage extends TestBase{
	
	WebDriverWait wait;
	
	@FindBy(xpath="//button[@class='btn btn-success']")
	WebElement placeorder;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement name;
	
	@FindBy(xpath="//input[@id='country']")
	WebElement country;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//input[@id='card']")
	WebElement creditCard;
	
	@FindBy(xpath="//input[@id='month']")
	WebElement month;
	
	@FindBy(xpath="//input[@id='year']")
	WebElement year;
	
	@FindBy(xpath="//button[@class='btn btn-primary'][@onclick='purchaseOrder()']")
	WebElement purchase;
	
	@FindBy(xpath="//button[text()='OK']")
	public WebElement ok;
	
	public PurchasePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void Placeorder () throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	    Thread.sleep(3000);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		placeorder.click();
		name.sendKeys("Niranjana");
		country.sendKeys("India");
		city.sendKeys("Erode");
		creditCard.sendKeys("12345");
		month.sendKeys("May");
		year.sendKeys("2022");
		wait.until(ExpectedConditions.visibilityOf(purchase));
		wait.until(ExpectedConditions.elementToBeClickable(purchase));
		purchase.click();
		Thread.sleep(3000);
		ok.click();
		
	}

}
