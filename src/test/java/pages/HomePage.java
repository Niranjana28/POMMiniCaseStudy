package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.TestBase;



public class HomePage extends TestBase{
	 Alert alert;
     WebDriverWait wait;
	 
	// WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	 @FindBy(xpath="//a[contains(text(),'Home')]")
     public WebElement home;
	
	 @FindBy(xpath="//a[contains(text(),'Add to cart')]")
	 public WebElement addtocartBtn;
	 
	 @FindBy(id="cartur")
	 WebElement cart;
	 
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	
	public void addItem(String MultipleItems) throws InterruptedException {
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		Thread.sleep(2000);
		home.click();
		Thread.sleep(2000);
		driver.findElement(By.linkText(MultipleItems)).click();
		wait.until(ExpectedConditions.elementToBeClickable(addtocartBtn));
		addtocartBtn.click();
	    wait.until(ExpectedConditions.alertIsPresent());
	    alert=driver.switchTo().alert();
	    alert.accept();
	    home.click();
	}
	public void cart() throws InterruptedException {
		cart.click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	
    }

	
}
