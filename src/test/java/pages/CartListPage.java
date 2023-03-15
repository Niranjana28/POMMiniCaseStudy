package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.TestBase;

public class CartListPage extends TestBase {
	WebDriverWait wait;
	@FindBy(id="totalp")
	WebElement price;
	
	@FindBy (xpath="(//a[text()='Delete'])[1]")
	WebElement deleteBtn;
	
	public CartListPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void delete() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(price));
		String valueBefore = price.getText();
		int iBefore=Integer.parseInt(valueBefore);
		deleteBtn.click();
		String valueAfter = price.getText();
		int iAfter=Integer.parseInt(valueAfter);
		Assert.assertNotEquals("iBefore", "iAfter");
	}
	

}
