package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.TestBase;

public class CartPage extends TestBase{
    
	WebDriverWait wait;
	@FindBy(id="cartur")
	WebElement cart;
		
	
	@FindBy (xpath="(//a[text()='Delete'])[1]")
	WebElement deleteBtn;
	
	@FindBy(xpath="//tbody//td[2]")
	public List<WebElement> items;
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}

	public void cart() throws InterruptedException {
		cart.click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	
		 
	}
	
	public void delete() throws InterruptedException {
		wait=new WebDriverWait(driver,Duration.ofSeconds(50));
		deleteBtn.click();
		
	}
	
	
}


