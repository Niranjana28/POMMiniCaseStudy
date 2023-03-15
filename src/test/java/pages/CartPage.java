package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CartPage extends TestBase{
    
	public String price;
	@FindBy(id="cartur")
	WebElement cart;
		
	@FindBy(id="totalp")
	WebElement priceno;
	
	@FindBy(xpath="//tbody//td[2]")
	public List<WebElement> items;
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	public void cart() throws InterruptedException {
		cart.click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		price = priceno.getText();
		 
	}
	
}


